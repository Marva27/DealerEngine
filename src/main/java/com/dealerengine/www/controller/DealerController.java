package com.dealerengine.www.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dealerengine.www.model.Dealer;
import com.dealerengine.www.model.Success;
import com.dealerengine.www.service.DealerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class DealerController {

	@Autowired
	private DealerService dealerService;
	
	@RequestMapping(name = "Get Dealer By Id", path = "/getDealerById/{dealerId}", produces = "application/json", method = RequestMethod.GET)
	@Operation(tags = "Single Dealer Operations")
	public ResponseEntity<Dealer> getDealerById(@PathVariable Integer dealerId) {
		return dealerService.getDealerById(dealerId);
	}

	@RequestMapping(name = "Add New Dealer", path = "/addNewDealer", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	@Operation(tags = "Single Dealer Operations")
	public ResponseEntity<Dealer> addNewDealer(@RequestBody Dealer dealer) {
		return dealerService.addNewDealer(dealer);
	}
	
	@RequestMapping(name = "Delete Dealer By Id", path = "/deleteDealerById", produces = "application/json", method = RequestMethod.DELETE)
	@Operation(tags = "Single Dealer Operations")
	public ResponseEntity<Success> deleteDealerById(@RequestParam Integer dealerId) {
		return dealerService.deleteDealerById(dealerId);
	}
	
	@RequestMapping(name = "Update Dealer By Id", path = "/updateDealerById", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
	@Operation(tags = "Single Dealer Operations")
	public ResponseEntity<Dealer> updateDealerById(@RequestParam Integer dealerId, @RequestBody Dealer dealer) {
		return dealerService.updateDealerById(dealerId, dealer);
	}
	
	@RequestMapping(name = "Bulk Upload Dealers", path = "/bulkUploadDealers", consumes = "multipart/form-data", produces = "application/json", method = RequestMethod.POST)
	@Operation(tags = "Bulk Dealer Operations")
	public ResponseEntity<Success> bulkUploadDealers(@RequestParam MultipartFile inputFile) throws IOException {
		return dealerService.bulkUploadDealers(inputFile.getInputStream());
	}
	
	@RequestMapping(name = "Delete All Dealers", path = "/deleteAllDealers", produces = "application/json", method = RequestMethod.DELETE)
	@Operation(tags = "Bulk Dealer Operations")
	public ResponseEntity<Success> deleteAllDealers() {
		return dealerService.deleteAllDealers();
	}
	
	@RequestMapping(name = "Get Dealers By State", path = "/getDealersByState", produces = "application/json", method = RequestMethod.GET)
	@Operation(tags = "Bulk Dealer Operations")
	public ResponseEntity<List<Dealer>> getDealersByState(@RequestParam String stateCode) {
		return dealerService.getDealersByState(stateCode);
	}
}
