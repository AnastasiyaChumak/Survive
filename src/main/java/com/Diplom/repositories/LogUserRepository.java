package com.Diplom.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Diplom.entity.LogUser;
import com.Diplom.entity.User;

@Repository
public interface LogUserRepository extends JpaRepository<LogUser, String> {

	Optional<LogUser> findByEmail(String string);

	LogUser findById(int id);

	void deleteById(int id);

}
