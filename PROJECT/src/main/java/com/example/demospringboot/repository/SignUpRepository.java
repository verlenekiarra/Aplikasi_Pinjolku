package com.example.demospringboot.repository;

import com.example.demospringboot.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Integer> {
    SignUp findBySignId(Integer signId);
}
