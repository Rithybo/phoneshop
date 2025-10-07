package com.rithy.java.school.phoneshop.service;

import com.rithy.java.school.phoneshop.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdaet);
}
