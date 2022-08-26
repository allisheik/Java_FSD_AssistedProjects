package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hobby")
public class HobbyController {
	
	@Autowired
	HobbyService service;
	
	
	@PostMapping("/")
	public ResponseEntity<Object> saveHobby(@RequestBody HobbyEntity hobby){
		
		HobbyEntity entity= service.saveHobby(hobby);
		
		if(entity!=null)
			return new ResponseEntity<Object>(entity, HttpStatus.CREATED);
		else 
			return new ResponseEntity<Object>("Error while inserting", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/{personId}")
	public ResponseEntity<Object> findHobby(@PathVariable int personId){
		String resp= service.findByPersonId(personId);
		
		if(resp!=null)
			return new ResponseEntity<Object>(resp,HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Hobby Not Available",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/{personId}")
	public ResponseEntity<Object> deleteHobby(@PathVariable int personId){
		boolean user= service.deleteHobby(personId);
		
		if(user==true)
			return new ResponseEntity<Object>("Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No User Found",HttpStatus.NOT_FOUND);
	}
}