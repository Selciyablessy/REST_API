package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{
    Page<Admin>findAll(Pageable pageable);

    
}
