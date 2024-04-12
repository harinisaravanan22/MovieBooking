package com.example.ticket1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ticket1.model.User;
@Repository
public interface UserRepo extends JpaRepository<User,String>{
  
}