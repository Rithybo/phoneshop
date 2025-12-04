package com.rithy.java.school.phoneshop.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.rithy.java.school.phoneshop.entity.Brand;
import com.rithy.java.school.phoneshop.exception.ApiException;
import com.rithy.java.school.phoneshop.exception.ResourceNotFoundException;
import com.rithy.java.school.phoneshop.repository.BrandRepository;
import com.rithy.java.school.phoneshop.service.BrandService;
import com.rithy.java.school.phoneshop.spac.BrandFilter;
import com.rithy.java.school.phoneshop.spac.BrandSpac;
import com.rithy.java.school.phoneshop.util.PageUtil;

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
//
//	@Override
//	public List<Brand> getBrands() {
//		return brandRepository.findAll();
//	}

//	@Override
//	public List<Brand> getBrands(String name) {
//		return brandRepository.findByNameContaining(name);
//	}
	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
	 	BrandFilter brandFilter = new BrandFilter();
		
		if(params.containsKey("name")) { //access filter from key
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if(params.containsKey("id")) {	
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		//@TODO add to function pagable
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
	 	int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		BrandSpac brandSpac = new BrandSpac(brandFilter);
		
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		Page<Brand> page = brandRepository.findAll(brandSpac, pageable);
		 return page;
	}



	
}
