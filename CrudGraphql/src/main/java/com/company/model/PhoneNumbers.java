package com.company.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phonenumbers")
public class PhoneNumbers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String contact;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="adress_id")
	private Adress adress;
	public PhoneNumbers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PhoneNumbers(Integer id, String contact) {
		super();
		this.id = id;
		this.contact = contact;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "PhoneNumbers [id=" + id + ", contact=" + contact + "]";
	}

	

}
