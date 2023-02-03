package com.spring.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spring.mongo.model.ContactName;
import com.spring.mongo.repository.ContactNameRepository;

@RestController
public class ContactNameController {

	@Autowired
	private ContactNameRepository repo;
	
	@PostMapping("/addContact")
	public String saveContact(@RequestBody ContactName contact) {
		
		repo.save(contact);
		return "Added Contact with id : "+contact.getId();
		
	}
	
	@GetMapping("/findAllContacts")
	public List<ContactName> getContacts(){
		
		return repo.findAll();
	}
	
	@GetMapping("/findContact/{id}")
	public Optional<ContactName> getContactById(@PathVariable int id){
		
		return repo.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteContact(@PathVariable int id) {
		
		repo.deleteById(id);
		return "Contact deleted with id :" +id;
	}
}
