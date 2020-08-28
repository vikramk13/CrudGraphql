package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.Adress;
import com.company.model.Person;

@org.springframework.stereotype.Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	/* Person findById(String id); */

	Person save(Adress adress);

	Person findByName(String name);

	Person findByPersonId(Integer id);

	Person findAdressById(Integer id);

}
