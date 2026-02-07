package com.rithy.java.school.phoneshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rithy.java.school.phoneshop.dto.ModelDTO;
import com.rithy.java.school.phoneshop.entity.Model;
import com.rithy.java.school.phoneshop.mapper.ModelEntityMapper;
import com.rithy.java.school.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;
//Mean for responsbody
@RestController 
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
	@Autowired
	private final ModelService modelService;
	private final ModelEntityMapper modelMapper;
	@PostMapping //for create request
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO) { //handler request or response
		Model model = modelService.save(modelDTO);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
	@GetMapping("{id}/brands")
	public ResponseEntity<?> findByBrandId(@PathVariable("id") Integer brandId){
		
		List<Model> brands = modelService.getByBrand(brandId);
		brands.stream()
				.map(model -> modelMapper.toModelDTO(model)).toList();
		return ResponseEntity.ok(brands);
		
	}
	
	
}
