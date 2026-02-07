package com.rithy.java.school.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.rithy.java.school.phoneshop.dto.ModelDTO;
//import com.rithy.java.school.phoneshop.entity.Brand;
import com.rithy.java.school.phoneshop.entity.Model;
import com.rithy.java.school.phoneshop.service.BrandService;

@Mapper( componentModel = "spring", uses = {BrandService.class})
public interface ModelEntityMapper {
	ModelEntityMapper  INSTANCE = Mappers.getMapper(ModelEntityMapper.class);
	@Mapping(target = "brand", source = "brandId") 
	Model toModel(ModelDTO dto);
	
	@Mapping(target = "brandId", source = "brand.id")
	ModelDTO toModelDTO(Model model);
	
//	default Brand toBrand(Integer brandId) {
//		Brand brand = new Brand();
//		brand.setId(brandId);
//		return brand;
//	}
}
