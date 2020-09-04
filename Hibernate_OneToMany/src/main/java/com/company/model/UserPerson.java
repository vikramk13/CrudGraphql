package com.company.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userperson")
public class UserPerson {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String  lastName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<Address> adress;

	public UserPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPerson(Integer id, String firstName, String lastName, List<Address> adress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Address> getAdress() {
		return adress;
	}

	public void setAdress(List<Address> adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "UserPerson [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", adress=" + adress
				+ "]";
	}

	
	
	
	
}
