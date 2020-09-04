package com.company;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.model.Address;
import com.company.model.UserPerson;
import com.company.repo.UserAdressRepo;
import com.company.repo.UserPersonRepo;

@SpringBootApplication
public class HibernateOneToManyApplication /* implements CommandLineRunner */ {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToManyApplication.class, args);
	}
	
	/*
	 * @Autowired private UserPersonRepo repo;
	 * 
	 * 
	 * @Autowired private UserAdressRepo repo1;
	 * 
	 * 
	 * 
	 * @Override public void run(String... args) throws Exception { // TODO
	 * Auto-generated method stub
	 * 
	 * 
	 * 
	 * 
	 * 
	 * UserPerson u=new UserPerson();
	 * 
	 * 
	 * 
	 * u.setFirstName("vijay"); u.setLastName("raaghava");
	 * 
	 * Address a=new Address();
	 * 
	 * a.setPlace("Bangalore"); a.setStreet("Marathahalli");
	 * 
	 * Address a1=new Address(); a1.setPlace("Hyderabad"); a1.setStreet("kphb");
	 * 
	 * 
	 * List<Address> adre= Arrays.asList(a,a1);
	 * 
	 * 
	 * u.setAdress(adre);
	 * 
	 * repo.save(u);
	 * 
	 * 
	 * 
	 * }
	 */

}
