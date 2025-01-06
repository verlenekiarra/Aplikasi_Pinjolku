package com.example.demospringboot.repository;

import com.example.demospringboot.entity.dataDiri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dataDiriRepository extends JpaRepository<dataDiri, String> {
}
