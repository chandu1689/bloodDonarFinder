package com.donateblood.com.donateblood.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiServie {
	
	@Value("${url.countryUrl}")
	private String countryUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<String> getCountries() {
		Object countries =restTemplate.getForObject(countryUrl, Object.class);
		List<Object> c=Arrays.asList(countries);
		Map<String,Object> data= (Map<String, Object>) c.get(0);
		Map<String,Map<String,String>> countryObjectMap= (Map<String, Map<String, String>>) data.get("data");
		return  countryObjectMap.entrySet().stream().map(countryObject->countryObject.getValue().get("country")).collect(Collectors.toList());
	}

}
