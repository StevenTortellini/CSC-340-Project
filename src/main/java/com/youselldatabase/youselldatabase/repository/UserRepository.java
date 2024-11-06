package com.youselldatabase.youselldatabase.repository;

import com.youselldatabase.youselldatabase.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
