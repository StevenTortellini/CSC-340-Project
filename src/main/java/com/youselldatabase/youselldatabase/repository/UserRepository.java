package com.youselldatabase.youselldatabase.repository;

import com.youselldatabase.youselldatabase.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
