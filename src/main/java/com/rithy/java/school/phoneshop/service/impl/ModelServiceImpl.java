package com.rithy.java.school.phoneshop.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rithy.java.school.phoneshop.dto.ModelDTO;
import com.rithy.java.school.phoneshop.entity.Model;
import com.rithy.java.school.phoneshop.mapper.ModelEntityMapper;
import com.rithy.java.school.phoneshop.repository.ModelRepository;
import com.rithy.java.school.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService{
	private final ModelRepository modelRepository;
	private final ModelEntityMapper modelMapper;
	@Override
	public Model save(ModelDTO dto) {
		Model model = modelMapper.toModel(dto);
		return modelRepository.save(model);
	}
	@Override
	public List<Model> getByBrand(Integer brandId) {
		return modelRepository.findByBrandId(brandId);
	}
}
