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
	
	@NotEmpty(message="Please enter the address details")
	@NotNull(message="This field is mandatory")
	private String addressLine;
	
	@NotEmpty(message="Please enter the Phone Number")
	@NotNull(message="Phone number is mandatory")
	@Pattern(regexp="[0-9]{10}", message="Please Enter a valid 10 digit Phone number")
	private String phoneNumber;
	
	@NotEmpty(message="Please enter the Pin")
	@NotNull(message="Pin is mandatory")
	@Pattern(regexp="[0-9]{6}", message="Please enter a valid 6 digit Pin")
	private String pin;
	
	@NotEmpty(message="Please select the state")
	@NotNull(message="State is mandatory")
	private String state;

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

	public Address toEntity() {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setAddressLine(this.addressLine);
		address.setPhoneNumber(this.phoneNumber);
		address.setPin(Integer.parseInt(this.pin));
		address.setState(States.getStateFromString(this.state));
		return address;
	}

	public static AddressDTO getDTO(Address entity) {
		
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressLine(entity.getAddressLine());
		addressDTO.setPhoneNumber(entity.getPhoneNumber());
		addressDTO.setPin(String.valueOf(entity.getPin()));
		addressDTO.setState(States.getStringFromState(entity.getState()));		
		return addressDTO;
	}
	
}
