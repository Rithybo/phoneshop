package com.rithy.java.school.phoneshop.utiltest;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralUtils {
	public static List<Integer> getListString(List<String> list){
		return list.stream()
		.map(s->s.length())
		.collect(Collectors.toList());
		
	}
	public static List<Integer> getEventNumber(List<Integer> list){
		 return list.stream()
		.filter(x -> x %2== 0).toList();
	}
}
