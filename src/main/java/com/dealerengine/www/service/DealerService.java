package com.dealerengine.www.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dealerengine.www.exception.ApplicationError;
import com.dealerengine.www.model.Dealer;
import com.dealerengine.www.model.Success;
import com.dealerengine.www.repository.DealerRepository;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@Service
public class DealerService {

	@Autowired
	private DealerRepository dealerRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public ResponseEntity<Dealer> addNewDealer(Dealer dealer) {
		if(dealerRepository.findByDealerId(dealer.getDealerId()) != null)
			throw new ApplicationError(ApplicationError.ErrorType.bad_request, "dealerId", "dealerId [" + dealer.getDealerId() + "] already exists");
		dealerRepository.save(dealer);
		return new ResponseEntity<Dealer>(dealer, HttpStatus.OK);
	}

	public ResponseEntity<Dealer> getDealerById(Integer dealerId) {
		Dealer dealer = dealerRepository.findByDealerId(dealerId);
		if(dealer != null)
			return new ResponseEntity<Dealer>(dealer, HttpStatus.OK);
		return null; 
	}

	public ResponseEntity<Success> bulkUploadDealers(InputStream fis) {
		CsvParserSettings csvParserSettings = new CsvParserSettings();
		csvParserSettings.setHeaderExtractionEnabled(false);
		CsvParser csvParser = new CsvParser(csvParserSettings);
		List<com.univocity.parsers.common.record.Record> allRecords = csvParser.parseAllRecords(fis);
		for(int i = 1; i < allRecords.size(); i++) {
			Dealer dealer = new Dealer();
			dealer.setDealerId(allRecords.get(i).getInt("DEALER_ID"));
			dealer.setDealerName(allRecords.get(i).getString("DEALER_NAME"));
			dealer.setDealerAddress(allRecords.get(i).getString("DEALER_ADDRESS"));
			dealer.setDealerCity(allRecords.get(i).getString("DEALER_CITY"));
			dealer.setDealerState(allRecords.get(i).getString("DEALER_STATE"));
			dealer.setDealerZipCode(allRecords.get(i).getInt("DEALER_ZIPCODE"));
			dealer.setDealerPhone(allRecords.get(i).getString("DEALER_PHONE"));
			dealerRepository.save(dealer);
		}
		Success success = new Success();
		success.setMessage("dealers loaded successfully!!!");
		return new ResponseEntity<Success>(success, HttpStatus.OK);
	}

	public ResponseEntity<Success> deleteDealerById(Integer dealerId) {
		try {
			dealerRepository.deleteByDealerId(dealerId);
			Success success = new Success();
			success.setMessage(dealerId + " deleted successfully!!!");
			return new ResponseEntity<Success>(success, HttpStatus.OK);
		}catch(Exception e) {
			throw new  ApplicationError(ApplicationError.ErrorType.bad_request, "dealerId", "error in deleting dealer", e);
		}
	}

	public ResponseEntity<Dealer> updateDealerById(Integer dealerId, Dealer dealer) {
		Dealer existingDealer = dealerRepository.findByDealerId(dealerId);
		if(existingDealer == null)
			throw new ApplicationError(ApplicationError.ErrorType.bad_request, "dealerId", "dealerId [" + dealerId + "] not exists");
		existingDealer = dealer;
		dealerRepository.save(existingDealer);
		return new ResponseEntity<Dealer>(dealer, HttpStatus.OK);
	}

	public ResponseEntity<Success> deleteAllDealers() {
		dealerRepository.deleteAll();
		Success success = new Success();
		success.setMessage("all dealers deleted successfully");
		return new ResponseEntity<Success>(success, HttpStatus.OK);
	}

	public ResponseEntity<List<Dealer>> getDealersByState(String stateCode) {
		Query query = new Query();
		query.addCriteria(Criteria.where("dealerState").is(stateCode));
		List<Dealer> matchingDealers = mongoTemplate.find(query, Dealer.class);
		return new ResponseEntity<List<Dealer>>(matchingDealers, HttpStatus.OK);
	}
}
