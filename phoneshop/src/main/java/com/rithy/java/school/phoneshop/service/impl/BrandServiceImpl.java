package com.rithy.java.school.phoneshop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.rithy.java.school.phoneshop.entity.Brand;
import com.rithy.java.school.phoneshop.exception.ApiException;
import com.rithy.java.school.phoneshop.exception.ResourceNotFoundException;
import com.rithy.java.school.phoneshop.repository.BrandRepository;
import com.rithy.java.school.phoneshop.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;
		
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		/*
		 Optional<Brand> brandOptional = brandRepository.findById(id);
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		} 
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id = %d not found".formatted(id));
		 */
		return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", id));	
	}
	@Override
	public Brand update(Integer id, Brand brandUpdaet) {
		// Call ID have or not 
		Brand brand = getById(id);
		//Set name.get name
		brand.setName(brandUpdaet.getName()); // @TODO improve updaet
		// return save 
		return brandRepository.save(brand);
	}
	
}
