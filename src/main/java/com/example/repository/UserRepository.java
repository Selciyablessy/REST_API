package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Page<User>findAll(Pageable pageable);
    List<User> findByBusId(Long busId);

} 