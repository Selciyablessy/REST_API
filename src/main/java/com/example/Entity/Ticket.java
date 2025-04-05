package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String busname;
    private String drivername;
    public Ticket(Long id,String username,String busname,String drivername)
    {
        this.id=id;
        this.username=username;
        this.busname=busname;
        this.drivername=drivername;
    }
    public Ticket()
    {

    }
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id=id;
    }
    
    public String getUserName()
    {
        return username;
    }
    public void setUserName(String username)
    {
        this.username=username;
    }

    public String getDriverName()
    {
        return drivername;
    }
    public void setDriverName(String drivername)
    {
        this.drivername=drivername;
    }

    public String getBusName()
    {
        return busname;
    }
    public void setBusName(String busname)
    {
        this.busname=busname;
    }   
}
