package com.rithy.java.school.phoneshop.service;

import com.rithy.java.school.phoneshop.entity.Model;

public interface ModelService {
	Model create(Model model);
	Model getById(Integer id);
}
