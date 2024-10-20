package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Admin;


@Service
public interface AdminService {

	public  Admin addalladmin(Admin admin);
	   
	   public Optional<Admin>  getbyid(int id);
	   
	   public List<Admin> getalladmin();
	   
	   
	   public void deleteadminbyid(int id);
	   
	   public void deletealladmin();
}
