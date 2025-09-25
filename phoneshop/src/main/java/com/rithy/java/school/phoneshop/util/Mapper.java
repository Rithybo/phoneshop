package com.rithy.java.school.phoneshop.util;

import com.rithy.java.school.phoneshop.dto.BrandDTO;

import com.rithy.java.school.phoneshop.entity.Brand;

public class Mapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}
}
