package com.group2.To_Do_App.exception.customException;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, Object resourceId) {
        super(resourceName + " with ID "+ resourceId + " not found");
    }

    public ResourceNotFoundException(String resourceName, String resourceEmail) {
        super(resourceName + " with Email:  "+ resourceEmail + " not found");
    }
}
