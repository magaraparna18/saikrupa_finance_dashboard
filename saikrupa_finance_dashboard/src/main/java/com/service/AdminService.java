package com.service;

import java.util.List;
import java.util.Optional;

import com.entity.AdminEntity;


public interface AdminService {
	
	//Admin Records Add
	public AdminEntity addAdminRecords(AdminEntity admin);
	
	//Admin GetRecords By ID
	public Optional<AdminEntity> getAdminRecordsById(Integer admin);
	
	//Admin Get All Records By ID
    public List<AdminEntity> getallAdminRecords();
    
   // Update Admin Record
 	public AdminEntity updateAdminRecord(Integer id, AdminEntity updatedAdmin);
	
    //Delete Admin Records By ID
	public void deleteAdminRecord(Integer id);
	
    //Delete All Admin Records 
	public void deleteallAdminRecord();
	


}
