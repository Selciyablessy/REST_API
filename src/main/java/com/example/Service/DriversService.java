package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Drivers;
import com.example.demo.repository.DriversRepository;

@Service
public class DriversService {
    @Autowired
    private  DriversRepository driversRepository;

    public DriversService(DriversRepository driversRepository)
    {
        this.driversRepository=driversRepository;
    }

    public List<Drivers> getAllDrivers()
    {
        return driversRepository.findAll();
    }

     public Drivers getDriverById(Long id)
    {
        return driversRepository.findById(id).orElse(null);
    }

    public Drivers createDriver(Drivers drivers)
    {
        return driversRepository.save(drivers);
    }

    public void deleteDriver(Long id)
    {
        driversRepository.deleteById(id);
    } 

   public Drivers updateDriver(Long id,Drivers drivers)
    {
       drivers.setId(id);
       return driversRepository.save(drivers);   
    }

   public List<Drivers> getDriverBusWithEqualto(Long busId) {
        return driversRepository.findByBusIdEqualTo(busId);
    }   
}