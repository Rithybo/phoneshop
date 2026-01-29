package com.rithy.java.school.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
	@PostMapping //for get request
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO) { //handler request or response
		Model model = modelService.save(modelDTO);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
	
}
