package com.xyz.mobilehandsetservice.dto;

import lombok.Data;

@Data
public class HandsetDetailVO {
    public int id;
    public String brand;
    public String phone;
    public String picture;
    public Release release;
    public String sim;
    public String resolution;
    public Hardware hardware;
}