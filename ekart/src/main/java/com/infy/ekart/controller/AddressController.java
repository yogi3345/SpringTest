package com.infy.ekart.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.infy.ekart.dto.AddressDTO;
import com.infy.ekart.entity.Address;
import com.infy.ekart.entity.State;
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

	@GetMapping("/add")
	@ResponseBody
	public ModelAndView addAddress(@PathVariable long userId, ModelMap model) {
		model.addAttribute("states", States.getAllStates());
		return new ModelAndView("welcome", "addAddress", new AddressDTO());
	}

	@PostMapping("/add")
	public ModelAndView updateAddress(@PathVariable long userId,
			@ModelAttribute("addAddress") @Valid AddressDTO addressDTO, BindingResult bindingResult, ModelMap model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("states", States.getAllStates());
			return new ModelAndView("welcome", "addAddress", addressDTO);
		}

		try {
			User user = userService.findById(userId);
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
		return new ModelAndView("welcome");
	}

}
