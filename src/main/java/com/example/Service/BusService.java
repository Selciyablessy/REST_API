package com.example.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bus;
import com.example.demo.repository.BusRepository;

@Service
public class BusService {
    @Autowired
    private  BusRepository busRepository;
    //constructor
    public BusService(BusRepository busRepository)
    {
        this.busRepository=busRepository;
    }
    public List<Bus> getAllBuses()
    {
        return busRepository.findAll();
    }

    public Bus createBus(Bus bus)
    {
        return busRepository.save(bus);
    }

    public void deleteBus(Long id)
    {
        busRepository.deleteById(id);
    }

    public List<Bus>getBusesByRating(int rating)
    {
        return busRepository.findByRating(rating);
    }

    public Bus updateBus(Long id,Bus bus)
    {
        bus.setId(id);
        return busRepository.save(bus);
    }


    public List<Bus> getBusesWithAmountGreaterThan(int minAmount) {
        return busRepository.findByAmountGreaterThan(minAmount);
    }

    public List<Bus> getBusesWithAmountLessThan(int maxAmount) {
        return busRepository.findByAmountLessThan(maxAmount);
    }

    public List<Bus> getBusesInAmountRange(int minAmount, int maxAmount) {
        return busRepository.findByAmountRange(minAmount, maxAmount);
    }

    public List<Bus> getBusesByRoute(String route) {
        return busRepository.findByRoute(route);
    }

    public List<Bus> getBusesWithCapacityGreaterThan(int minCapacity) {
        return busRepository.findByCapacityGreaterThan(minCapacity);
    }
    public Bus getBusById(Long id) {
        return busRepository.findById(id).orElse(null);
    }
    
}
