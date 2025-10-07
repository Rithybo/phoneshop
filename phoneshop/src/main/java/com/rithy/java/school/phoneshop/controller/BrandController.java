package com.rithy.java.school.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rithy.java.school.phoneshop.dto.BrandDTO;
import com.rithy.java.school.phoneshop.entity.Brand;
import com.rithy.java.school.phoneshop.service.BrandService;
import com.rithy.java.school.phoneshop.util.MapperBrand;

@RestController //Mean for responbody
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = MapperBrand.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(MapperBrand.toBrandDTO(brand));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(MapperBrand.toBrandDTO(brand));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBrand(@RequestBody Brand brandUpdate, @PathVariable Integer id){
		Brand update = brandService.update(id, brandUpdate);
		return ResponseEntity.ok(MapperBrand.toBrandDTO(update));
	}
}
