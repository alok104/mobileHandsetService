package com.xyz.mobilehandsetservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.mobilehandsetservice.constant.Constant;
import com.xyz.mobilehandsetservice.dto.HandsetDetailVO;
import com.xyz.mobilehandsetservice.service.MobileHandsetService;

@RestController
@RequestMapping(value = Constant.BASE_URI)
public class MobileHandsetSearchController {

	@Autowired
	private MobileHandsetService handsetService;

	@GetMapping(Constant.SEARCH_URI)
	public List<HandsetDetailVO> getHandsetDetails(@RequestParam(required = false) Double priceEur , @RequestParam(required = false) String sim, 
			@RequestParam(required = false) Integer announceDate, @RequestParam(required = false) Double price) {
		return handsetService.getHandsetDetails(priceEur, sim, announceDate, price);
	}

}
