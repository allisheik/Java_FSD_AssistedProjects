package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	//add method or CREATE RECORD
	public User addUser(User u) {
		return repo.save(u);
	}
	
	
	//List user Method
	public List<User> getAllUser(){
		return repo.findAll();
	}
	
	//get user by id
	public User getUserById(int id) {
		if(repo.findById(id).isPresent()) 
			return repo.findById(id).get();
		else 
			return null;
		
	}
	//update user by id
public  User updateUser(User user, int id) {
		
		if(repo.findById(id).isPresent())
		{
			User old= repo.findById(id).get();
			old.setCountry(user.getCountry());
			old.setName(user.getName());
			old.setEmail(user.getEmail());
			
			return repo.save(old);
		}
		else
		{
			return null;
		}
		
	}
	
	///DELETE USER BY ID
	public boolean deleteUser(int id) {
	
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

}