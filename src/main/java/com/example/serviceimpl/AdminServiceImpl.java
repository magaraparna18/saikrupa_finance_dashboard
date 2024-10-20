package com.example.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.repo.AdminRepo;
import com.example.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
@Autowired
AdminRepo adminrepo;

@Override
public Admin addalladmin(Admin admin) {
	return adminrepo.save(admin);
}



@Override
public List<Admin> getalladmin() {
	return adminrepo.findAll();
}

@Override
public void deleteadminbyid(int id) {
	adminrepo.deleteById(id);
	
}

@Override
public void deletealladmin() {
	adminrepo.deleteAll();
	
}

@Override
public Optional<Admin> getbyid(int id) {
 return adminrepo.findById(id); 

	

}
}