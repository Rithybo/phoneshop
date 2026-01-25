package com.rithy.java.school.phoneshop.service.impl;
import org.springframework.stereotype.Service;

import com.rithy.java.school.phoneshop.dto.ModelDTO;
import com.rithy.java.school.phoneshop.entity.Model;
import com.rithy.java.school.phoneshop.mapper.ModelMapper;
import com.rithy.java.school.phoneshop.repository.ModelRepository;
import com.rithy.java.school.phoneshop.service.ModelService;


import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService{
	private final ModelRepository modelRepository;
	private final ModelMapper modelMapper;
	@Override
	public Model save(ModelDTO dto) {
		Model model = modelMapper.toModel(dto);
		return modelRepository.save(model);
	}
}
