package com.ytc.dec29.controller;

import java.util.List;

import com.ytc.dec29.service.CompanyService;
import com.ytc.dec29.dto.CompanyDTO;
import com.ytc.dec29.model.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;
    
    @RequestMapping("/getAll")
    public List<Company> getAll() {
        return companyService.getAll();
    }
    
    @RequestMapping("/login")
    public int login(String name, String password) {
        System.out.println("login()");
        if (!companyService.doesCompanyExist(name)) {
            return 1;
        } else if (!companyService.checkPassword(name, password)) {
            return 2;
        } else {
            return 3;
        }
    }
}
