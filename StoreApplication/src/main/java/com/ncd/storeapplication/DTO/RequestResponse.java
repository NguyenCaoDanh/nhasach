package com.ncd.storeapplication.DTO;

import com.ncd.storeapplication.DTO.response.Token;
import com.ncd.storeapplication.entity.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestResponse {
    private final String status = "success";
    private String timestamp;
    private String message;
    private Object data;

    public RequestResponse(Object data) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = "";
        this.data = data;
    }
    public RequestResponse(String message) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.data = null;
    }
}