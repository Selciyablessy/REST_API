package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private String phone;
    private Long busId;
    public Drivers(Long id,String name,String licenseNumber,String phone,Long busId)
    {
        this.id=id;
        this.name=name;
        this.licenseNumber=licenseNumber;
        this.phone=phone;
        this.busId=busId;
    }
    public Drivers()
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
    public Long getBusId()
    {
        return busId;
    }

    public void setBusId(Long busId)
    {
        this.busId=busId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public String getLicenseNumber()
    {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber)
    {
        this.licenseNumber=licenseNumber;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }   
}
