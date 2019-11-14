package com.infy.ekart.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infy.ekart.entity.User;

public class UserDTO {

	@NotEmpty(message="Please enter the name")
	@NotNull(message="Name is mandatory")
    private String name;
	
	@NotEmpty(message="Please enter the password")
	@NotNull(message="Password is mandatory")
    private String password;
	
	@NotEmpty(message="Please confirm the password")
    private String passwordConfirm;
    
	@NotEmpty(message="Please enter the Email Id")
	@NotNull(message="Email Id is mandatory")
	@Pattern(regexp = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message="Please enter valid Email Id")
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
