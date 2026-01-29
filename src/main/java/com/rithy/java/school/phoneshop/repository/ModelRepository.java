package com.rithy.java.school.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rithy.java.school.phoneshop.entity.Model;
@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>{
	List<Model> findByBrandId(Integer brandId);
}
