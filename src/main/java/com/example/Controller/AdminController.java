package com.example.demo.Controller;

import java.util.List;

import org.springframework.data.domain.Page;

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

import com.example.demo.Entity.Admin;
import com.example.demo.Service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private  AdminService adminService;

    public AdminController(AdminService adminService)
    {
        this.adminService=adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins()
    {
        return adminService.getAllAdmins();
    }
    //pagination
    @GetMapping("/adminpaginated")
    public Page<Admin>getAdmins(@RequestParam(defaultValue ="0") int page,@RequestParam(defaultValue = "10")int size)
    {
        return adminService.getAdminsWithPagination(page,size);
    }
    //sorting
    @GetMapping("/adminsorted")
    public List<Admin>sortByAdmin()
    {
        return adminService.sortByAdmin();
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin)
    {
        return adminService.createAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id)
    {
        adminService.deleteAdmin(id);
        return "Admin "+id+" has been deleted successfully ";
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id,@RequestBody Admin admin)
    {
        return adminService.updateAdmin(id, admin);
    }
}
