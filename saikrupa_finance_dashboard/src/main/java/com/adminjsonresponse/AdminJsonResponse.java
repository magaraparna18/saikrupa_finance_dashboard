package com.adminjsonresponse;

import com.adminentity.AdminEntity;
import lombok.Data;

@Data
public class AdminJsonResponse {
    
    private String status;
    private String message;
    private AdminEntity result; // You can also use List<AdminEntity> if needed
    
    // Parameterized Constructor
    public AdminJsonResponse(String status, String message, AdminEntity result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
    
    // Default Constructor
    public AdminJsonResponse() {
        super();
    }
}
