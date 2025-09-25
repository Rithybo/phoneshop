package com.rithy.java.school.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rithy.java.school.phoneshop.dto.BrandDTO;
import com.rithy.java.school.phoneshop.entity.Brand;
import com.rithy.java.school.phoneshop.service.BrandService;
import com.rithy.java.school.phoneshop.util.Mapper;

@RestController //Mean for responbody
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = Mapper.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(brand);
		
	}
	
}
