package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Drivers;
@Repository
public interface DriversRepository extends JpaRepository<Drivers,Long> {

    //custom JPQL query
     // Find drivers assigned to a specific bus
     @Query("SELECT d FROM Drivers d WHERE d.busId = :busId")
     List<Drivers> findByBusIdEqualTo(@Param("busId") Long busId); 

} 