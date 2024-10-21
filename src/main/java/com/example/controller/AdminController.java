package com.example.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Admin;
import com.example.serviceimpl.AdminServiceImpl;
import com.json.JsonResponcse;
@RestController
public class AdminController {
	@Autowired

	private AdminServiceImpl adminservice;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonResponcse addreocrds(@RequestBody Admin admin) {

		JsonResponcse responce = new JsonResponcse();

		
		if(admin!=null)
		{
			adminservice.addalladmin(admin);
			responce.setStatus("200OK");
			responce.setResult("Success");
			responce.setMessage("Shop admin Succesfully !! With id=");
		}
		 else {
				responce.setStatus("300OK");
				responce.setResult("USuccess");
				responce.setMessage("datanotsaved");
			}
		return responce;

	}
	@PutMapping("/updatedata/{id}")
	public ResponseEntity<JsonResponcse> updatedata(@RequestBody Admin admin, @PathVariable int id) {
	    JsonResponcse response = new JsonResponcse();
	    Optional<Admin> existingAdmin = adminservice.getbyid(id);

	    if (existingAdmin.isPresent()) {
	        Admin adminToUpdate = existingAdmin.get();

	        // Update the fields of the existing admin
	        adminToUpdate.setAdminLogin(admin.getAdminLogin());
	        adminToUpdate.setDashboard(admin.getDashboard());
	        adminToUpdate.setRegisterstaff(admin.getRegisterstaff());
	        adminToUpdate.setRegisterclient(admin.getRegisterclient());
	        adminToUpdate.setAllocatestaffagainstResisterclient(admin.getAllocatestaffagainstResisterclient());
	        adminToUpdate.setCreateStatusMaster(admin.getCreateStatusMaster());
	        adminToUpdate.setClientlist(admin.getClientlist());
	        adminToUpdate.setStafflogin(admin.getStafflogin());
	        adminToUpdate.setUpdateclientstatus(admin.getUpdateclientstatus());

	        // Save the updated admin
	        adminservice.addalladmin(admin);
	        // Ensure this method is implemented

	        response.setMessage("Data updated successfully for ID " + id);
	        response.setStatus("200 OK");
	        response.setResult("Success");
	        
	        return ResponseEntity.ok(response); // Return a 200 OK response
	    } else {
	        response.setStatus("404 NOT FOUND");
	        response.setResult("Unsuccessful");
	        response.setMessage("Admin with ID " + id + " is not present in the database.");
	        
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // Return a 404 NOT FOUND response
	    }
	}

	@DeleteMapping("/delete/{id}")
	public JsonResponcse getdeletebyid(@PathVariable int id) {
		JsonResponcse responce = new JsonResponcse();

		Optional<Admin> admin1 = adminservice.getbyid(id);
		if (admin1.isPresent()) {
			adminservice.deleteadminbyid(id);
			responce.setStatus("200OK");
			responce.setResult("Success");
			responce.setMessage("Shop Deleted  Succesfully !!");
		} else {
			responce.setStatus("300OK");
			responce.setResult("UnSuccess");
			responce.setMessage("Shop Not Present In Data  !!");
		}

		return responce;

	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<Admin> getShopById(@PathVariable int id) {
	    Optional<Admin> data = adminservice.getbyid(id);

	    if (data.isPresent()) {
	        // Return the Admin object directly, automatically serialized to JSON
	        return ResponseEntity.ok(data.get());
	    } else {
	        // Return a 404 NOT FOUND response with a custom error message
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body(null);
	    }
	    // Optionally, return an error message in the body
	    }
	    
	
	    @GetMapping("/getall")
	    public List<Admin> getalllist()
	    {
	    	
	    
	    List<Admin> getalladmin=  adminservice.getalladmin();
		return getalladmin;
		
	}
    }

