package com.youselldatabase.youselldatabase.repository;

import com.youselldatabase.youselldatabase.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Integer> {
}