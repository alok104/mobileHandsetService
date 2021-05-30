package com.xyz.mobilehandsetservice.service;

import java.util.List;

import com.xyz.mobilehandsetservice.dto.HandsetDetailVO;

public interface MobileHandsetService {

	List<HandsetDetailVO> getHandsetDetails(Double priceEur, String sim, Integer announceDate, Double price);
	
}
