package com.cts.authorizationmodule.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.authorizationmodule.model.UserModel;
import com.cts.authorizationmodule.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user=userRepository.findById(username).orElse(null);
		if(user!=null) {
			return new User(user.getId(), user.getPassword(), new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
	}

}
