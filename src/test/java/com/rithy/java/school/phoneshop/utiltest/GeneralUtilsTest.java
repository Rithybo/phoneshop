package com.rithy.java.school.phoneshop.utiltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GeneralUtilsTest {
	@Test
	public void testGetListString() {
		List<String> name = List.of("Rithy","Proseth","Panhchorpor","Lyly");
		List<Integer> list = GeneralUtils.getListString(name);
		
		assertEquals(4, list.size());
		assertEquals(5,list.get(0));
		assertEquals(7,list.get(1));
		assertEquals(11,list.get(2));
		assertEquals(4,list.get(3));
	}
	@Test
	public void testGetEventNumber() {
		//Given
		List<Integer> list =List.of(4,5,6,8,10); 
		//when
		List<Integer> eventNumber = GeneralUtils.getEventNumber(list);
		//then
		assertEquals(4, eventNumber.size());
		assertEquals(4, eventNumber.get(0));
	}
}
