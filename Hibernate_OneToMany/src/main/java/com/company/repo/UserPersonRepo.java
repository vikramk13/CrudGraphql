package com.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.model.UserPerson;

@Repository
public interface UserPersonRepo extends JpaRepository<UserPerson, Integer> {

}
