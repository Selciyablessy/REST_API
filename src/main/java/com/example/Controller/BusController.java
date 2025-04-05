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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Bus;
import com.example.demo.Entity.User;
import com.example.demo.Service.BusService;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/busses")
public class BusController {
    @Autowired
    private  BusService busService;
    @Autowired
    private UserService userService;

    public BusController(BusService busService)
    {
        this.busService=busService;
    }

    @GetMapping
    public List<Bus> getAllBuses()
    {
        return busService.getAllBuses();
    }

    @PostMapping
    public Bus createBus(@RequestBody Bus bus)
    {
        return busService.createBus(bus);
    }

    @DeleteMapping("/{id}")
    public String deleteBus(@PathVariable Long id)
    {
        busService.deleteBus(id);
        return "Bus "+id+" has been deleted successfully ";
    }

    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable Long id,@RequestBody Bus bus)
    {
        return busService.updateBus(id, bus);
    }

    @GetMapping("/rating/{rating}")
    public List<Bus> getBusesByRating(@PathVariable int rating)
    {
        return busService.getBusesByRating(rating);
    }



    @GetMapping("/amount-greater-than/{minAmount}")
    public List<Bus> getBusesWithAmountGreaterThan(@PathVariable int minAmount) 
    {
        return busService.getBusesWithAmountGreaterThan(minAmount);
    }

    @GetMapping("/amount-less-than/{maxAmount}")
    public List<Bus> getBusesWithAmountLessThan(@PathVariable int maxAmount) 
    {   
        return busService.getBusesWithAmountLessThan(maxAmount);
    }

    @GetMapping("/amount-range")
    public List<Bus> getBusesInAmountRange(@RequestParam int min, @RequestParam int max) 
    {
        return busService.getBusesInAmountRange(min, max);
    }

    @GetMapping("/route/{route}")
    public List<Bus> getBusesByRoute(@PathVariable String route) 
    {
        return busService.getBusesByRoute(route);
    }

    @GetMapping("/capacity-greater-than/{minCapacity}")
    public List<Bus> getBusesWithCapacityGreaterThan(@PathVariable int minCapacity) 
    {
        return busService.getBusesWithCapacityGreaterThan(minCapacity);
    }
    @PostMapping("/{busId}/addUser")
    public User addUserToBus(@PathVariable Long busId, @RequestBody User user) {
        Bus bus = busService.getBusById(busId);
        if (bus != null) {
            user.setBus(bus);
            return userService.createUser(user);
        }
        return null;
    }

    @GetMapping("/{busId}/users")
    public List<User> getUsersForBus(@PathVariable Long busId) {
        return userService.getUsersByBusId(busId);
    }

}
