package com.Diplom.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Diplom.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

	User findById(String id);

	Optional<User> findByEmail(String string);
	
	User findUserByEmail(String string);
	
	List<User> findByNameLike(String name); 

}
