package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private  AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository)
    {
        this.adminRepository=adminRepository;
    }
    
    public List<Admin> getAllAdmins()
    {
        return adminRepository.findAll();
    }

    public Page<Admin>getAdminsWithPagination(int page,int size)
    {
        Pageable pageable=PageRequest.of(page, size);
        return adminRepository.findAll(pageable);
    }
    public List<Admin>sortByAdmin()
    {
        return adminRepository.findAll(Sort.by("name").ascending());
    }
    
    public Admin getAdminById(Long id)
    {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin createAdmin(Admin admin)
    {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id)
    {
        adminRepository.deleteById(id);
    }

    public Admin updateAdmin(Long id,Admin admin)
    {
       admin.setId(id);
       return adminRepository.save(admin);
    }
}
