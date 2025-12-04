package com.rithy.java.school.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//
import org.springframework.stereotype.Repository;

import com.rithy.java.school.phoneshop.entity.Brand;
// Data Access Layer JPA
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>,JpaSpecificationExecutor<Brand>{
//	List<Brand> findByNameLikeIgnoreCase(String name);//Custom method by manual

	List<Brand> findByNameContaining(String name);
}
 