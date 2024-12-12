package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Transactional
    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }


    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public void save(Admin admin) {
        adminRepository.save(admin);
    }
}

