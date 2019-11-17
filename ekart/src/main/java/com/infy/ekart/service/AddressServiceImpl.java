package com.infy.ekart.service;

import java.util.ArrayList;
import java.util.List;

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
	public Address getById(long id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id);
	}

	@Override
	public List<Address> getAddressesByUser(long userId) {
		// TODO Auto-generated method stub
		List<Address> addressEntityList = addressRepository.findByUserId(userId);
		return addressEntityList;
	}

	@Override
	public void deleteAddress(long id) {
		// TODO Auto-generated method stub
		addressRepository.deleteById(id);
	}

}
