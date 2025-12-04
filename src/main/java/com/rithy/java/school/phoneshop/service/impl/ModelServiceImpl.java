package com.rithy.java.school.phoneshop.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.rithy.java.school.phoneshop.entity.Model;
import com.rithy.java.school.phoneshop.repository.ModelRepository;
import com.rithy.java.school.phoneshop.service.ModelService;
@Service
public class ModelServiceImpl implements ModelService{
	@Autowired
	private ModelRepository modelRepository;
	
	@Override
	public Model create(Model model) {
		return modelRepository.save(model);
	}

	@Override
	public Model getById(Integer id) {
		Optional<Model> modelOptional = modelRepository.findById(id);
		if(modelOptional.isPresent()) {
			return modelOptional.get();
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Model with id = "+ id +"not found");
	}
	
	
}
