package com.dealerengine.www.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dealerengine.www.model.Dealer;

@Repository
public interface DealerRepository extends MongoRepository<Dealer, Integer> {
	Dealer findByDealerId(Integer dealerId);
	void deleteByDealerId(Integer dealerId);
}
