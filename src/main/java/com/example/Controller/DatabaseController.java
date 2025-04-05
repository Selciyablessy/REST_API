package com.example.demo.Controller;

import com.example.demo.Service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/database")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @DeleteMapping("/drop-bus-id")
    public String deleteBusIdColumn() {
        return databaseService.dropColumnFromDriver();
    }
}
