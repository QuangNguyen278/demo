package com.example.demo.repository;

import com.example.demo.model.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface postRepository extends JpaRepository<post, Long> {
}

