package com.rithy.java.school.phoneshop.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rithy.java.school.phoneshop.dto.BrandDTO;
import com.rithy.java.school.phoneshop.dto.PageDTO;
import com.rithy.java.school.phoneshop.entity.Brand;
import com.rithy.java.school.phoneshop.mapper.BrandMapper;
import com.rithy.java.school.phoneshop.service.BrandService;
import com.rithy.java.school.phoneshop.util.MapperBrand;
@RestController //Mean for responbody
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
//		Brand brand = MapperBrand.toBrand(brandDTO);
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(MapperBrand.toBrandDTO(brand));
	}
	
	
	
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	} 
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand updateBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updateBrand));
	}
//	@GetMapping
//	public ResponseEntity<?> getBrands(){ 
//		List<BrandDTO> list = brandService.getBrands()
//				.stream()
//				.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
//				.collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//	}
	 // This case for have 1 par
//	@GetMapping("filter") 
//	public ResponseEntity<?> getBrands(@RequestParam("name") String name){ 
//		List<BrandDTO> list = brandService.getBrands(name)
//				.stream()
//				.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
//				.collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//	}
	
	@GetMapping 
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){ 
		Page<Brand> page = brandService.getBrands(params);
		
		PageDTO pageDTO = new PageDTO(page);
//		List<BrandDTO> list = brandService.getBrands(params)
//				.stream()
//				.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
//				.collect(Collectors.toList());
		return ResponseEntity.ok(pageDTO);
	}
	

	
}
