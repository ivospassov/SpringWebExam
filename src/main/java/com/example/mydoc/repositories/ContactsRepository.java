package com.example.mydoc.repositories;

import com.example.mydoc.models.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<Message, Long> {
}
