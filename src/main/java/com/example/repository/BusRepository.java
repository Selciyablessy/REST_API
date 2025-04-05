package com.example.demo.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> 
{
    List<Bus> findByRating(int rating);

    //custom JPQL query
    // Find buses with amount greater than a given value
    @Query("SELECT b FROM Bus b WHERE b.amount > :minAmount")
    List<Bus> findByAmountGreaterThan(@Param("minAmount") int minAmount);

    // Find buses with amount less than a given value
    @Query("SELECT b FROM Bus b WHERE b.amount < :maxAmount")
    List<Bus> findByAmountLessThan(@Param("maxAmount") int maxAmount);

    // Find buses within a range of amounts
    @Query("SELECT b FROM Bus b WHERE b.amount BETWEEN :minAmount AND :maxAmount")
    List<Bus> findByAmountRange(@Param("minAmount") int minAmount, @Param("maxAmount") int maxAmount);

    // Find buses by route
    @Query("SELECT b FROM Bus b WHERE b.route = :route")
    List<Bus> findByRoute(@Param("route") String route);

    // Find buses with capacity greater than a given value
    @Query("SELECT b FROM Bus b WHERE b.capacity > :minCapacity")
    List<Bus> findByCapacityGreaterThan(@Param("minCapacity") int minCapacity);

} 
