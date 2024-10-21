package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AdminEntity;
import com.jsonresponse.AdminJsonResponse;
import com.serviceimpl.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

@Autowired
AdminServiceImpl adminservice;

    // Add Admin Record
    @PostMapping("/addadmin")
    public AdminEntity addAdminRecord(@RequestBody AdminEntity admin) {
        return adminservice.addAdminRecords(admin);
    }

    // Get Admin Record By ID
    @GetMapping("/get/{adminId}")
    public AdminJsonResponse getAdminRecordById(@PathVariable Integer adminId) {
        AdminJsonResponse response = new AdminJsonResponse();
        Optional<AdminEntity> admin = adminservice.getAdminRecordsById(adminId);

        if (admin.isPresent()) {
            response.setMessage(admin.get().toString());
            response.setResult(admin.get());
            response.setStatus("200");
        } else {
            response.setMessage("Admin ID not found");
            response.setResult(null);
            response.setStatus("404");
        }
        return response;
    }

    // Get All Admin Records
    @GetMapping("/getAll")
    public List<AdminEntity> getAllAdminRecords() {
        return adminservice.getallAdminRecords();
    }

    // Update Admin Record
    @PutMapping("/update/{id}")
    public AdminJsonResponse updateAdminRecord(@RequestBody AdminEntity updatedAdmin, @PathVariable Integer id) {
        AdminJsonResponse response = new AdminJsonResponse();
        Optional<AdminEntity> adminOptional = adminservice.getAdminRecordsById(id);

        if (adminOptional.isPresent()) {
            AdminEntity existingAdmin = adminOptional.get();
            // Set updated fields from updatedAdmin
            existingAdmin.setAdminName(updatedAdmin.getAdminName());
            existingAdmin.setAdminEmail(updatedAdmin.getAdminEmail());
            existingAdmin.setAdminPassword(updatedAdmin.getAdminPassword());
            existingAdmin.setCreatedDate(updatedAdmin.getCreatedDate());

            adminservice.addAdminRecords(existingAdmin);
            response.setMessage("Admin updated successfully");
            response.setResult(existingAdmin);
            response.setStatus("200");
        } else {
            response.setMessage("Admin not found");
            response.setResult(null);
            response.setStatus("404");
        }
        return response;
    }

    // Delete Admin Record by ID
    @DeleteMapping("/delete/{id}")
    public AdminJsonResponse deleteAdminRecord(@PathVariable Integer id) {
        AdminJsonResponse response = new AdminJsonResponse();
        Optional<AdminEntity> admin = adminservice.getAdminRecordsById(id);

        if (admin.isPresent()) {
        	adminservice.deleteAdminRecord(id);
            response.setMessage("Admin deleted successfully");
            response.setResult(null);
            response.setStatus("200");
        } else {
            response.setMessage("Admin ID not found");
            response.setResult(null);
            response.setStatus("404");
        }
        return response;
    }

    // Delete All Admin Records
    @DeleteMapping("/deleteAll")
    public AdminJsonResponse deleteAllAdminRecords() {
        AdminJsonResponse response = new AdminJsonResponse();
        try {
            adminservice.deleteallAdminRecord();
            response.setMessage("All admin records deleted successfully");
            response.setResult(null);
            response.setStatus("200");
        } catch (Exception e) {
            response.setMessage("Error deleting admin records");
            response.setResult(null);
            response.setStatus("500");
        }
        return response;
    }
}
