package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.model.Adress;
import com.company.model.Person;
import com.company.repository.PersonRepository;

@org.springframework.stereotype.Service
public class PersonService {

	@Autowired
	private PersonRepository repo;

	public Person add(Person person) {
		// TODO Auto-generated method stub

		return repo.save(person);

	}

	public Person getInfo(String name) {
		// TODO Auto-generated method stub

		return repo.findByName(name);

	}

	public Person addAdress(Adress adress) {

		return repo.save(adress);
	}
	
	
	

}
