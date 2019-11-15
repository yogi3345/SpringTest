package com.infy.ekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infy.ekart.entity.Address;
import com.infy.ekart.repository.AddressRepository;

@Component
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public void Save(Address address) {
		// TODO Auto-generated method stub
		addressRepository.save(address);
	}

	@Override
	public Address findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
