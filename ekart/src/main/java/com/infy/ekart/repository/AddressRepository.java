package com.infy.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Address findById(long id);
}
