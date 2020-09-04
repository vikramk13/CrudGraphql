package com.company.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Address;

@Repository
public interface UserAdressRepo extends JpaRepository<Address, Integer> {

	void save(List<Address> adre);

}
