package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

@Service
public class DatabaseService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public String dropColumnFromDriver() {
        try {
            String sql = "ALTER TABLE driver DROP COLUMN bus_id";
            Query query = entityManager.createNativeQuery(sql);
            query.executeUpdate();
            return "Column 'bus_id' deleted successfully!";
        } catch (Exception e) {
            return "Error deleting column: " + e.getMessage();
        }
    }
}
