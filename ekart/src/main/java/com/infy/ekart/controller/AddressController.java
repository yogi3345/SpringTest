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

	@GetMapping
	public String viewAddress(@PathVariable long userId, ModelMap model) {
		List<AddressDTO> addressDTOs = new ArrayList<AddressDTO>();
		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UsernameNotFoundException(environment.getProperty("address.user.NOTFOUND"));
			List<Address> addressEntityList = addressService.getAddressesByUser(userId);
			if (!addressEntityList.isEmpty())
				addressDTOs = addressEntityList.stream().map(entity -> AddressDTO.getDTO(entity))
						.collect(Collectors.toList());
		} catch (UsernameNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		model.addAttribute("addressesSize", addressDTOs.size());
		model.addAttribute("addresses", addressDTOs);
		return "address";
	}

	@GetMapping("/add")
	public String addAddressForm(@PathVariable long userId, ModelMap model) {
		model.addAttribute("states", States.getAllStates());
		model.addAttribute("addAddress", new AddressDTO());
		return "address";
	}

	@PostMapping("/add")
	public String addAddressSubmit(@PathVariable long userId,
			@ModelAttribute("addAddress") @Valid AddressDTO addressDTO, BindingResult bindingResult, ModelMap model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("states", States.getAllStates());
			model.addAttribute("addAddress", addressDTO);
			return "address";
		}

		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UsernameNotFoundException(environment.getProperty("address.user.NOTFOUND"));
			Address address = addressDTO.toEntity();
			address.setUser(user);
			addressService.Save(address);
			model.addAttribute("success", environment.getProperty("address.add.SUCCESS"));
		} catch (UsernameNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "address";
	}

	@DeleteMapping("/{addressId}/delete")
	public String deleteAddress(@PathVariable long userId, @PathVariable long addressId, ModelMap model) {
		return "redirect:/"+userId+"/address";
	}

}
