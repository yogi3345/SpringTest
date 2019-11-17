package com.infy.ekart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.ekart.dto.AddressDTO;
import com.infy.ekart.entity.Address;
import com.infy.ekart.entity.User;
import com.infy.ekart.exception.AddressNotFoundException;
import com.infy.ekart.exception.UserAndAddressMismatchException;
import com.infy.ekart.exception.UserNotFoundException;
import com.infy.ekart.service.AddressService;
import com.infy.ekart.service.UserService;
import com.infy.ekart.utilities.States;

@Controller
@RequestMapping("/{userId}/address")
public class AddressController {

	@Autowired
	UserService userService;

	@Autowired
	AddressService addressService;

	@Autowired
	Environment environment;

	/*@GetMapping
	public String viewAddress(@PathVariable long userId, ModelMap model) throws UserNotFoundException, AddressNotFoundException {
		List<AddressDTO> addressDTOs = new ArrayList<AddressDTO>();
		//try {
			User user = userService.getById(userId);
			if (user != null)
				throw new UserNotFoundException(environment.getProperty("address.user.NOTFOUND"));
			System.out.println("2222222222222222222");
			List<Address> addressEntityList = addressService.getAddressesByUser(userId);
			if (!addressEntityList.isEmpty())
				addressDTOs = addressEntityList.stream().map(entity -> AddressDTO.getDTO(entity))
						.collect(Collectors.toList());
			if (addressDTOs.size() == 0)
				throw new AddressNotFoundException(environment.getProperty("address.view.NOTFOUND"));
			model.addAttribute("addresses", addressDTOs);
		} catch (UsernameNotFoundException | AddressNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "address";
	}*/
	
	@GetMapping
	public String viewAddress(@PathVariable long userId, ModelMap model) throws UserNotFoundException, AddressNotFoundException {
		List<AddressDTO> addressDTOs = new ArrayList<AddressDTO>();
		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UserNotFoundException(environment.getProperty("address.user.NOTFOUND"));
			List<Address> addressEntityList = addressService.getAddressesByUser(userId);
			if (!addressEntityList.isEmpty())
				addressDTOs = addressEntityList.stream().map(entity -> AddressDTO.getDTO(entity))
						.collect(Collectors.toList());
			if (addressDTOs.size() == 0)
				throw new AddressNotFoundException(environment.getProperty("address.view.NOTFOUND"));
			model.addAttribute("addresses", addressDTOs);
		} catch (UsernameNotFoundException | AddressNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "index";
	}

	@GetMapping("/add")
	public String addAddressForm(@PathVariable long userId, ModelMap model) {
		model.addAttribute("states", States.getAllStates());
		model.addAttribute("addAddress", true);
		model.addAttribute("command", new AddressDTO());
		return "index";
	}

	@PostMapping("/add")
	public String addAddressSubmit(@PathVariable long userId,
			@ModelAttribute("command") @Valid AddressDTO addressDTO, BindingResult bindingResult, ModelMap model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("states", States.getAllStates());
			model.addAttribute("addAddress", true);
			model.addAttribute("command", addressDTO);
			return "index";
		}

		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UserNotFoundException(environment.getProperty("address.user.NOTFOUND"));
			Address address = addressDTO.toEntity();
			address.setUser(user);
			addressService.Save(address);
			model.addAttribute("success", environment.getProperty("address.add.SUCCESS"));
		} catch (UsernameNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "index";
	}

	@GetMapping("/{addressId}/delete")
	public String deleteAddress(@PathVariable long userId, @PathVariable long addressId, ModelMap model) {
		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UserNotFoundException(environment.getProperty("address.user.NOTFOUND"));
			Address address = addressService.getById(addressId);
			if (address == null)
				throw new AddressNotFoundException(environment.getProperty("address.modify.NOTFOUND"));
			addressService.deleteAddress(address.getId());
			model.addAttribute("success", environment.getProperty("address.delete.SUCCESS"));
		} catch (UsernameNotFoundException | AddressNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "redirect:/"+userId+"/address";
	}

	@GetMapping("/{addressId}/modify")
	public String modifyAddressForm(@PathVariable long userId, @PathVariable long addressId, ModelMap model) {
		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UserNotFoundException(environment.getProperty("address.user.NOTFOUND"));
			Address address = addressService.getById(addressId);
			if (address == null)
				throw new AddressNotFoundException(environment.getProperty("address.modify.NOTFOUND"));
			if (!user.equals(address.getUser()))
				throw new UserAndAddressMismatchException(environment.getProperty("address.user.MISMATCH"));
			model.addAttribute("states", States.getAllStates());
			model.addAttribute("modifyAddress", AddressDTO.getDTO(address));
			model.addAttribute("command", new AddressDTO());
		} catch (UsernameNotFoundException | AddressNotFoundException | UserAndAddressMismatchException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "index";
	}

	@PostMapping("/{addressId}/modify")
	public String editAddressSubmit(@PathVariable long userId, @PathVariable long addressId,
			@ModelAttribute("command") @Valid AddressDTO addressDTO, BindingResult bindingResult,
			ModelMap model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("states", States.getAllStates());
			model.addAttribute("modifyAddress", addressDTO);
			return "index";
		}

		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UserNotFoundException(environment.getProperty("address.user.NOTFOUND"));
			Address address = addressService.getById(addressId);
			if (address == null)
				throw new AddressNotFoundException(environment.getProperty("address.modify.NOTFOUND"));
			if (!user.equals(address.getUser()))
				throw new UserAndAddressMismatchException(environment.getProperty("address.user.MISMATCH"));
			address.setAddressLine(addressDTO.getAddressLine());
			address.setPhoneNumber(addressDTO.getPhoneNumber());
			address.setPin(Integer.parseInt(addressDTO.getPin()));
			address.setCity(addressDTO.getCity());
			address.setState(States.getStateFromString(addressDTO.getState()));
			addressService.Save(address);
			model.addAttribute("success", environment.getProperty("address.modify.SUCCESS"));
		} catch (UsernameNotFoundException | AddressNotFoundException | UserAndAddressMismatchException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "redirect:/"+userId+"/address";
	}
}
