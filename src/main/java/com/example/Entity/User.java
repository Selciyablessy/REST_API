package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

     @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    public User()
    {
        
    }
    public User(Long id,String name,String email,Bus bus)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.bus=bus;
    }
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id=id;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public Bus getBus() 
    {
         return bus; 
    }
    public void setBus(Bus bus) 
    { 
        this.bus = bus; 
    }
}
