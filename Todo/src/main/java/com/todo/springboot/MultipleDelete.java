package com.todo.springboot;

public class MultipleDelete {
	public static Long[] todo_id(TodoData mydata) {
		//get todoID
		String multiple = mydata.getMultiple();
		//convert to String array
		String[] array_string = multiple.split(",");
		//convert to long array
		//method needs the long value
		Long[] array_long = new Long[array_string.length];
		for (int i = 0; i < array_string.length; i++) {
			array_long[i] = Long.valueOf(array_string[i]);
		}
		//return value
		return (Long[]) array_long;
	}
}
