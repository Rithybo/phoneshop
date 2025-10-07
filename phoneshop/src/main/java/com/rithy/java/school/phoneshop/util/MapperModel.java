package com.rithy.java.school.phoneshop.util;

import com.rithy.java.school.phoneshop.dto.ModelDTO;
import com.rithy.java.school.phoneshop.entity.Model;

public class MapperModel {
	public static Model toModel(ModelDTO modDto) {
		Model model = new Model();
//		brand.setId(dto.getId());
		model.setName(modDto.getName());
		return model;
	}

	public static ModelDTO toModelDTO(Model model) {
		ModelDTO modelDTO = new ModelDTO();
		modelDTO.setName(model.getName());
		return modelDTO;
	}
}
