package com.infy.ekart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Address findById(long id);

	List<Address> findByUserId(long userId);
}
