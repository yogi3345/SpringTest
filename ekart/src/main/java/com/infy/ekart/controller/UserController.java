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
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infy.ekart.dto.UserDTO;
import com.infy.ekart.entity.User;
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
	public ModelAndView registration(ModelMap model) {

		return new ModelAndView("registration", "command", new UserDTO());
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("command") @Valid UserDTO userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		User user = userForm.toEntity();

		userService.save(user);

		securityService.autoLogin(user.getEmail(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", environment.getProperty("user.login.ERROR"));

		if (logout != null)
			model.addAttribute("message", environment.getProperty("user.logout.SUCCEESS"));

		return "login";
	}

	@GetMapping("/{userId}/update")
	public ModelAndView modifyAccountDetails(@PathVariable long userId, ModelMap model, HttpSession httpSession) {
		// System.out.println(userEmail + userService);
		ModelAndView modelAndView = new ModelAndView("welcome");
		try {
			User user = userService.findById(userId);
			if (user == null)
				throw new UsernameNotFoundException(environment.getProperty("user.update.USERNOTFOUND"));
			UserDTO userDTO = user.toDTO();
			model.addAttribute("user", userDTO);
			model.addAttribute("command", new UserDTO());
		} catch (UsernameNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return modelAndView;
	}

	@PostMapping("/{userId}/update")
	public ModelAndView modifyAccountDetails(@PathVariable long userId,
			@Valid @ModelAttribute("command") UserDTO userDTO, BindingResult bindingResult, ModelMap model,
			HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", userDTO);
			model.addAttribute("command", userDTO);
			return modelAndView;
		}
		try {
			User user = userService.findById(userId);
			if (user == null)
				throw new UsernameNotFoundException(environment.getProperty("user.update.USERNOTFOUND"));
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
		return modelAndView;
	}
}
