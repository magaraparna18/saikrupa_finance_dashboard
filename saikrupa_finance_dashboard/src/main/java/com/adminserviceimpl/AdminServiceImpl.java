package com.adminserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminentity.AdminEntity;
import com.adminrepository.AdminRepository;
import com.adminservice.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminrepo;
	
	@Override
	public AdminEntity addAdminRecords(AdminEntity admin) {
		return adminrepo.save(admin);
	}

	@Override
	public Optional<AdminEntity> getAdminRecordsById(Integer admin) {
		return adminrepo.findById(admin);
	}

	@Override
	public List<AdminEntity> getallAdminRecords() {
		return adminrepo.findAll();
	}

	@Override
	public AdminEntity updateAdminRecord(Integer id, AdminEntity updatedAdmin) {
		return adminrepo.save(updatedAdmin);
	}

	@Override
	public void deleteAdminRecord(Integer id) {
		adminrepo.deleteById(id);
		
	}

	@Override
	public void deleteallAdminRecord() {
		adminrepo.deleteAll();
	}
	
}
