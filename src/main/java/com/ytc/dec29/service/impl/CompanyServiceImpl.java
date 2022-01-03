package com.ytc.dec29.service.impl;

import java.util.List;

import com.ytc.dec29.mapper.CompanyMapper;
import com.ytc.dec29.model.Company;
import com.ytc.dec29.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyMapper companyMapper;
    
    @Override
    public List<Company> getAll(){
        List<Company> list = companyMapper.getAllCompanies();
        return list;
    }

    @Override
    public boolean doesCompanyExist(String name){
        if (companyMapper.doesCompanyExist(name)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPassword(String name, String password){
        if(companyMapper.getPassword(name, password).equals(password)){
            return true;
        } else {
            return false;
        }
    }
}
