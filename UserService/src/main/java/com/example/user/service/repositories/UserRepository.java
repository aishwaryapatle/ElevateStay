package com.example.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.service.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	//if you want to implement any custom method or query
	//write
}
