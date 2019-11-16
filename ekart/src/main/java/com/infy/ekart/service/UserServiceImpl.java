package com.infy.ekart.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.infy.ekart.entity.Role;
import com.infy.ekart.entity.User;
import com.infy.ekart.repository.RoleRepository;
import com.infy.ekart.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<Role>());
        userRepository.save(user);
    }

    @Override
    public User getByUsername(String email) {
        return userRepository.findByEmail(email);
    }

	@Override
	public User getById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
}
