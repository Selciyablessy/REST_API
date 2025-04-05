package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private   UserRepository userRepository;

   
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Page<User>getUsersWithPagination(int page,int size)
    {
        Pageable pageable=PageRequest.of(page, size);
        return userRepository.findAll(pageable);    
    }
    public List<User>sortByUser()
    {
        return userRepository.findAll(Sort.by("name").ascending());
    }

    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id,User user)
    {
        user.setId(id);
        return userRepository.save(user);
    }
    public List<User> getUsersByBusId(Long busId) {
        return userRepository.findByBusId(busId);
    }
   
}
