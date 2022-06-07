package com.example.practise.repository;

import com.example.practise.model.PM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PMRepository extends JpaRepository<PM,Long> {
}
