package com.rithy.java.school.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rithy.java.school.phoneshop.dto.ModelDTO;
import com.rithy.java.school.phoneshop.entity.Model;
import com.rithy.java.school.phoneshop.service.ModelService;
import com.rithy.java.school.phoneshop.util.MapperModel;

@RestController //Mean for responbody
@RequestMapping("models")
public class ModelController {
	@Autowired
	private ModelService modelService;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO) {
		Model model = MapperModel.toModel(modelDTO);
		model = modelService.create(model);
		return ResponseEntity.ok(MapperModel.toModelDTO(model));
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer modInteger){
		Model model = modelService.getById(modInteger);
		return ResponseEntity.ok(MapperModel.toModelDTO(model));
	}
	
}
