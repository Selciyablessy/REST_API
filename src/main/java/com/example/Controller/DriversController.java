package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Drivers;
import com.example.demo.Service.DriversService;

@RestController
@RequestMapping("/api/driivers")
public class DriversController {
    @Autowired
    private  DriversService driversService;

    
    public DriversController(DriversService driversService)
    {
        this.driversService=driversService;
    }
    
    @GetMapping
    public List<Drivers> getAllDrivers()
    {
        return driversService.getAllDrivers();
    }

    @PostMapping
    public Drivers createDriver(@RequestBody Drivers drivers)
    {
        return driversService.createDriver(drivers);
    }

    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable Long id)
    {
        driversService.deleteDriver(id);
        return "Driver "+id+" has been deleted successfully ";

    }

    @PutMapping("/{id}")
    public Drivers updateDriver(@PathVariable Long id,@RequestBody Drivers drivers)
    {
        return driversService.updateDriver(id, drivers);
    }

     @GetMapping("/equalto/{busId}")
    public List<Drivers> getDriverBusWithEqualto(@PathVariable Long busId) 
    {
        return driversService.getDriverBusWithEqualto(busId);
    }

}

