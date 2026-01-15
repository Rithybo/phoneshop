package com.rithy.java.school.phoneshop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rithy.java.school.phoneshop.entity.Brand;
import com.rithy.java.school.phoneshop.exception.ResourceNotFoundException;
import com.rithy.java.school.phoneshop.repository.BrandRepository;
import com.rithy.java.school.phoneshop.service.impl.BrandServiceImpl;
@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	@Mock
	private BrandRepository brandRepository;
	
	private BrandService brandService;
	@BeforeEach
	public void setUp() {
		brandService = new BrandServiceImpl(brandRepository);
	}
	/*
	@Test
	public void Testcreate() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1);
		
		Brand brand2 = new Brand();
		brand.setName("Apple");
		//when
			
			//  This mean for test any brand 
			  when(brandRepository.save(any(Brand.class))).thenReturn(brand); // @Mock 
			  Brand brandReturn = brandService.create(new Brand());
			 
		
		// This test for specify brand because have (brand2)
		when(brandRepository.save(brand2)).thenReturn(brand);
		Brand brandReturn = brandService.create(brand2);
			
		//then
			assertEquals(1, brandReturn.getId());
			assertEquals("Apple", brandReturn.getName());
	}
*/
	
	@Test
	public void testCreate() {
		//Give 
		Brand brand = new Brand();
		brand.setName("Apple");
		//When
		brandService.create(brand);//when brandService call brand if across save 
		//then
		verify(brandRepository, times(1)).save(brand);// so this mean brandService has been save 
	}
	@Test
	public void testGetById() {
		//given
		Brand brand = new Brand(); // object 
		brand.setName("Apple");
		brand.setId(1);
		//when 
		when(brandRepository.findById(1)).thenReturn(Optional.of(brand));//when brandRepository find id 1 fond then it will return object has been prepare 
		Brand brandReturn = brandService.getById(1); //call real function getById 1 so it will return 1 
		//then
		assertEquals(1, brandReturn.getId()); //so assert brandReturn id 1 ?
		assertEquals("Apple", brandReturn.getName());
	}
	@Test
	public void testGetByIdThrow() {
		//given
				Brand brand = new Brand(); // object 
				brand.setName("Apple");
				brand.setId(1);
				//when 
				when(brandRepository.findById(4)).thenReturn(Optional.empty());
//				Brand brandReturn = brandService.getById(4);
				assertThatThrownBy(() -> brandService.getById(4))
				.isInstanceOf(ResourceNotFoundException.class) // test throw exception 
				.hasMessage(String.format("%s With id= %d not found","Brand",4));
//				.hasMessage("Brand With id= 4 not found"); can use too 
//				.hasMessageEndingWith("not found"); can use too 
				//then
				
				
	}
}
