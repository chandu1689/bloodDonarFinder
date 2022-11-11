package com.donateblood.com.donateblood.controller;

import java.util.List;

import com.donateblood.com.donateblood.model.UserRegistration;
import com.donateblood.com.donateblood.service.BloodGroupsService;
import com.donateblood.com.donateblood.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donateblood.com.donateblood.service.ExternalApiServie;

@RestController
@RequestMapping("/api")
public class DonateBloodController {
	
	@Autowired
	ExternalApiServie apiServie;

	@Autowired
	BloodGroupsService bloodGroupsService;

	@Autowired
	UserRegistrationService userRegistrationService;

	
	@GetMapping("/getCountries")
	public List<String> getCountries() {
		return apiServie.getCountries();
	}

	@GetMapping("/getBloodGroups")
	public List<String> getBloodGroups(){
		return bloodGroupsService.getBloodGroups();
	}

	@GetMapping("/registerUser")
	public String registerUser(@RequestBody UserRegistration userRegistration){
		return userRegistrationService.registerUser(userRegistration);
	}

}
