package com.infy.ekart.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.infy.ekart.entity.Address;
import com.infy.ekart.entity.State;
import com.infy.ekart.utilities.States;

public class AddressDTO {
	
	private long id;
	
	@NotEmpty(message="Please enter the address details")
	@NotNull(message="This field is mandatory")
	private String addressLine;
	
	@NotNull(message="Phone number is mandatory")
	@Pattern(regexp="[0-9]{10}", message="Please Enter a valid 10 digit Phone number")
	private String phoneNumber;
	
	@NotNull(message="Pin is mandatory")
	@Pattern(regexp="[0-9]{6}", message="Please enter a valid 6 digit Pin")
	private String pin;
	
	@NotEmpty(message="Please select the state")
	@NotNull(message="State is mandatory")
	private String state;
	
	@NotNull(message="City is mandatory")
	@Pattern(regexp="[A-Za-z][A-Za-z\\s]{1,30}", message="Please enter a valid City")
	private String city;

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address toEntity() {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setAddressLine(this.addressLine);
		address.setPhoneNumber(this.phoneNumber);
		address.setCity(this.city);
		address.setPin(Integer.parseInt(this.pin));
		address.setState(States.getStateFromString(this.state));
		return address;
	}

	public static AddressDTO getDTO(Address entity) {
		
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setId(entity.getId());
		addressDTO.setAddressLine(entity.getAddressLine());
		addressDTO.setPhoneNumber(entity.getPhoneNumber());
		addressDTO.setPin(String.valueOf(entity.getPin()));
		addressDTO.setCity(entity.getCity());
		addressDTO.setState(States.getStringFromState(entity.getState()));		
		return addressDTO;
	}
	
}
