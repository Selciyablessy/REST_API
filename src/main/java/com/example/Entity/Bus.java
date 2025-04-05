package com.example.demo.Entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String busNumber;
    private String route;
    private int capacity;
    private int amount;
    private int rating;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    public Bus()
    {

    }
    
    public Bus(Long id,String name,String busNumber,String route,int capacity,int rating,int amount)
    {
        this.id=id;
        this.name=name;
        this.busNumber=busNumber;
        this.route=route;
        this.capacity=capacity;
        this.rating=rating;
        this.amount=amount;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id=id;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount=amount;
    }


    public String getbusNumber()
    {
        return busNumber;
    }

    public void setbusNumber(String busNumber)
    {
        this.busNumber=busNumber;
    }

    public String getroute()
    {
        return route;
    }

    public void setroute(String route)
    {
        this.route=route;
    }
    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity=capacity;
    }
    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating=rating;
    }    
}
