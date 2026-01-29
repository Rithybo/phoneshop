package com.rithy.java.school.phoneshop.controller;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rithy.java.school.phoneshop.dto.BrandDTO;
import com.rithy.java.school.phoneshop.dto.PageDTO;
import com.rithy.java.school.phoneshop.entity.Brand;
import com.rithy.java.school.phoneshop.entity.Model;
import com.rithy.java.school.phoneshop.mapper.BrandMapper;
import com.rithy.java.school.phoneshop.mapper.ModelEntityMapper;
import com.rithy.java.school.phoneshop.service.BrandService;
import com.rithy.java.school.phoneshop.service.ModelService;
import com.rithy.java.school.phoneshop.util.MapperBrand;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController //Mean for responbody
@RequestMapping("brands")
public class BrandController {
//	@Autowired
	private final BrandService brandService;
	private final ModelService modelService;
	private final ModelEntityMapper modelMapper;
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
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand updateBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updateBrand));
	}
	@GetMapping 
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){ 
		Page<Brand> page = brandService.getBrands(params);
		PageDTO pageDTO = new PageDTO(page);
		return ResponseEntity.ok(pageDTO);
	}

	@GetMapping("{id}/models")
	public ResponseEntity<?> getModelById(@PathVariable("id") Integer brandId){
		List<Model> brands = modelService.getByBrand(brandId);
		brands.stream()
				.map(model -> modelMapper.toModelDTO(model)).toList();
		return ResponseEntity.ok(brands);
	}

	

	
}
