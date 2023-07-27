package com.example.demo.repository;

import com.example.demo.model.like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface likeRepository extends JpaRepository<like, Long> {
}