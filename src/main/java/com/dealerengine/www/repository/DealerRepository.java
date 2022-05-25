package com.dealerengine.www.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealerengine.www.model.Dealer;

public interface DealerRepository extends MongoRepository<Dealer, Integer> {
	
	public Dealer findByDealerId(Integer dealerId);

}
