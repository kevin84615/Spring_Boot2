package com.todo.springboot;

import java.util.Arrays;
import java.util.List;

public class Multiple {
	public static List<Long> delete(String todoid) {
		String [] string_array = todoid.split(",");
		Long[] long_array = new Long[string_array.length];
		for (int i = 0; i < long_array.length; i++) {
			long_array[i] = Long.valueOf(string_array[i]);
		}
		List<Long> inputAsList = Arrays.asList(long_array);
		return inputAsList;
		}

}
