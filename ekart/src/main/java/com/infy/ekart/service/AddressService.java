package com.infy.ekart.service;

import java.util.List;

import com.infy.ekart.entity.Address;
import com.infy.ekart.entity.User;

public interface AddressService {
	
	void Save(Address address);
	Address getById(long id);
	List<Address> getAddressesByUser(long userId);
	void deleteAddress(long id);
}
