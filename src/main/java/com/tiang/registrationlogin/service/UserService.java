package com.tiang.registrationlogin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiang.registrationlogin.model.User;
import com.tiang.registrationlogin.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	

	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public User  creat(User user) {
		return userRepository.save(user);
			
	}
	public ArrayList<User> findAll(){
		return (ArrayList<User>) userRepository.findAll();
	
	}
	public User findById(Long id) {
	 return userRepository.findById(id).get();
	} 
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public User findByEmailAndPassword(String email , String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}

