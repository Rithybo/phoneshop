package com.rithy.java.school.phoneshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rithy.java.school.phoneshop.entity.Brand;
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

}
