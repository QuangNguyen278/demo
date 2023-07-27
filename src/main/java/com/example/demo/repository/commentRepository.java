package com.example.demo.repository;

import com.example.demo.model.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository extends JpaRepository<comment, Long> {
}
