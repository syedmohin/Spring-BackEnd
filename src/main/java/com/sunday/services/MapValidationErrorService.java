package com.sunday.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> mapValidationService(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMsg = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMsg.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMsg, BAD_REQUEST);
        }
        return null;
    }
}
