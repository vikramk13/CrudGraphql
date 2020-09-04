package com.company.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Address;
import com.company.model.UserPerson;
import com.company.repo.UserAdressRepo;
import com.company.repo.UserPersonRepo;


@RestController
@RequestMapping("/api")
public class UserPersonController {
	
	@Autowired
	private UserPersonRepo userrepo;
	
	
	
	
	
	
	@Autowired
	private UserAdressRepo repo1;
	
	
	@PostMapping("createuser")
	public UserPerson create(@RequestBody UserPerson user)
	{
		
	return 	userrepo.save(user);
	}
	
	
	
	@GetMapping("getUserInfo/{id}")
	public Optional<com.company.model.UserPerson> getById(@PathVariable Integer id)
	{
		
	return 	userrepo.findById(id);
	}
	
	@GetMapping("getAdress/{id}")
	public Optional<Address> get(@PathVariable Integer id)
	{
		
	return 	repo1.findById(id);
	}

}
