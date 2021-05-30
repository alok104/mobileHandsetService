package com.xyz.mobilehandsetservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "handsetDetail")
public class HandsetDetail {
	@Id
    public int id;
    public String brand;
    public String phone;
    public String picture;
    public ReleaseVO release;
    public String sim;
    public String resolution;
    public HardwareVO hardware;
}