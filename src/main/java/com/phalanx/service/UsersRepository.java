package com.phalanx.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phalanx.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

       // custom query to search in contact
    List<Users> findByLastNameContaining(String text);  
}