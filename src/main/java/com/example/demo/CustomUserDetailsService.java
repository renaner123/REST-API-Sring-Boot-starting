package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	//buscar um usuário pelo email no banco de dados
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomUserDetails(user);
	}

}
