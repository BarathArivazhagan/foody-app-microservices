package com.barath.app.service;

import java.util.Arrays;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.barath.app.model.Address;
import com.barath.app.model.User;
import com.barath.app.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
		
	
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User createUser(User user) {
		return this.userRepository.save(user);
	}
	
	public Optional<User> getUser(Long userId){
		return this.userRepository.findById(userId);		
	}
	
	public boolean validateUser(String email,String password) {
		
		User user = this.userRepository.findByEmail(email);
		if(user !=null) {
			return  password.equals(user.getPassword());
		}		
		
		return false;
	}
	
	@PostConstruct
	public void init() {
		Address address = new Address("ADDR1", "ADDR2", "TAMILNADU", "CHENNAI", "600081");
		User user1 =new User(1L, "Barath", "Arivazhagan", "demo", address, "demo");
		User user2 =new User(2L, "BARRY", "Arivazhagan", "demo1", address, "demo");
		User user3 =new User(3L, "BARI", "Arivazhagan", "demo2", address, "demo");
		Arrays.asList(user1,user2,user3)
			.stream().forEach(this::createUser);
	}

}
