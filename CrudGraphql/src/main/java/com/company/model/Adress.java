package com.company.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private  String place;
	
	
	
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name= "person_id")
	  private Person person;
	 
	
	@OneToMany(mappedBy = "adress",cascade = CascadeType.ALL)
	private Set<PhoneNumbers> phone;

	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adress(Integer id, String place, Set<PhoneNumbers> phone) {
		super();
		this.id = id;
		this.place = place;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Set<PhoneNumbers> getPhone() {
		return phone;
	}

	public void setPhone(Set<PhoneNumbers> phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", place=" + place + ", phone=" + phone + "]";
	}
	
	

}
