package com.ytc.dec29.service;

import java.util.List;

import com.ytc.dec29.dto.CompanyDTO;
import com.ytc.dec29.mapper.CompanyMapper;
import com.ytc.dec29.model.Company;
import com.ytc.dec29.model.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CompanyService {
    
    List<Company> getAll();
    public boolean doesCompanyExist(String name);
    public boolean checkPassword(String name, String password);
}
