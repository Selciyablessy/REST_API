package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/usersss")
public class UserController {
    @Autowired
    private  UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @GetMapping
    public List<User>getAllUsers()
    {
        return userService.getAllUsers();
    }
    //pagination
    @GetMapping("/paginated")
    public Page<User>getUsers(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size)
    {
        return userService.getUsersWithPagination(page, size);
    }
   //sorting the user based on name
    @GetMapping("/sorted")
    public List<User>sortByUser()
    {
        return userService.sortByUser();
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return "User "+id+" has been deleted successfully ";

    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user)
    {
        return userService.updateUser(id, user);
    }  
}
