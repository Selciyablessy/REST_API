package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String busname;
    private int amount;
    public Transaction(Long id,String username,String busname,int amount)
    {
        this.id=id;
        this.username=username;
        this.busname=busname;
        this.amount=amount;
    }
    public Transaction()
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
    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount=amount;
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
