package com.rithy.java.school.phoneshop.service;
import com.rithy.java.school.phoneshop.dto.ModelDTO;
import com.rithy.java.school.phoneshop.entity.Model;

public interface ModelService {
	
	Model save(ModelDTO dto);
//	List<Model> getByBrand(Integer brendId);
}
