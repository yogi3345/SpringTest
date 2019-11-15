package com.infy.ekart.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.Address;

public interface AddressService {
	
	void Save(Address address);
	Address findById(long id);
}
