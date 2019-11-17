package com.infy.ekart.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infy.ekart.entity.User;

public class UserDTO {

	@NotNull(message = "Name is mandatory")
	@Pattern(regexp="[A-Za-z][A-Za-z\\s]+", message="Only Alphabets along with spaces are allowed")
	private String name;

	@NotNull(message = "Password is mandatory")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{4,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one number and one special character")
	private String password;

	private String passwordConfirm;

	@NotNull(message = "Email Id is mandatory")
	@Pattern(regexp = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message = "Please enter valid Email Id")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User toEntity() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName(this.name);
		user.setPassword(this.password);
		user.setEmail(this.email);
		return user;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", email="
				+ email + "]";
	}

}
