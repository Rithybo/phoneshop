package com.rithy.java.school.phoneshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rithy.java.school.phoneshop.entity.Brand;
@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;
@Test
	public void testFindByNameLike() {
		// given
		Brand brand = new Brand();
		brand.setName("Apple");
//		Brand brand1 = new Brand();
//		brand1.setName("Samsung");
		brandRepository.save(brand);
//		brandRepository.save(brand1);
		// when
		List<Brand> byNameLike = brandRepository.findByNameLike("%A%");
		// then
		assertEquals(1,byNameLike.size()); 
		assertEquals("Apple", byNameLike.get(0).getName());
		assertEquals(1, byNameLike.get(0).getId());
	} 
	
}
