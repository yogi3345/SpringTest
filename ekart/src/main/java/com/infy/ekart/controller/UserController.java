package com.infy.ekart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.infy.ekart.dto.UserDTO;
import com.infy.ekart.entity.User;
import com.infy.ekart.exception.UserNotFoundException;
import com.infy.ekart.service.SecurityService;
import com.infy.ekart.service.UserService;
import com.infy.ekart.utilities.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	Environment environment;

	@GetMapping("/registration")
	public String registration(ModelMap model) {

		model.addAttribute("command", new UserDTO());
		model.addAttribute("showRegister", true);
		return "index";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("command") @Valid UserDTO userForm, BindingResult bindingResult,
			ModelMap model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("showRegister", true);
			return "index";
		}
		User user = userForm.toEntity();

		userService.save(user);

		securityService.autoLogin(user.getEmail(), userForm.getPasswordConfirm());

		return "redirect:/home";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", environment.getProperty("user.login.ERROR"));

		if (logout != null)
			model.addAttribute("message", environment.getProperty("user.logout.SUCCEESS"));

		model.addAttribute("showLogin", true);
		return "index";
	}

	@GetMapping("/{userId}/update")
	public String modifyAccountDetails(@PathVariable long userId, ModelMap model, HttpSession httpSession) {

		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UserNotFoundException(environment.getProperty("user.update.USERNOTFOUND"));
			UserDTO userDTO = user.toDTO();
			model.addAttribute("user", userDTO);
			model.addAttribute("command", new UserDTO());
		} catch (UsernameNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "index";
	}

	@PostMapping("/{userId}/update")
	public String modifyAccountDetails(@PathVariable long userId, @Valid @ModelAttribute("command") UserDTO userDTO,
			BindingResult bindingResult, ModelMap model, HttpSession httpSession) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("user", userDTO);
			model.addAttribute("command", userDTO);
			return "index";
		}
		try {
			User user = userService.getById(userId);
			if (user == null)
				throw new UserNotFoundException(environment.getProperty("user.update.USERNOTFOUND"));
			user.setName(userDTO.getName());
			user.setPassword(userDTO.getPassword());
			userService.save(user);
			httpSession.setAttribute("userName", user.getName());
			model.addAttribute("success", environment.getProperty("user.update.SUCCESS"));
		} catch (UsernameNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "index";
	}
}
