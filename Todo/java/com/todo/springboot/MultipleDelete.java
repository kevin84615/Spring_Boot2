package com.todo.springboot;

public class MultipleDelete {
	public static Long[] todo_id(TodoData mydata) {
		// get todoID & todoText
		String multiple = mydata.getMultiple();
		multiple = multiple.replaceAll(",", "");
		// convert to String array
		String[] array_string = multiple.split("&split;%");
		// convert to long array
		// method needs the long value
		int counter = array_string.length / 2;
		Long[] array_long = new Long[counter];
		int c = 0;
		for (int i = 0; i < counter; i++) {
			array_long[i] = Long.valueOf(array_string[c]);
			c = c + 2;
		}
		return (Long[]) array_long;
	}

	public static String[] todo_text(TodoData mydata) {
		// get todoID & todoText
		String multiple = mydata.getMultiple();
		multiple = multiple.replaceAll(",", "");
		// convert to String array
		String[] array_string = multiple.split("&split;%");
		//put todoText to new array
		int counter = array_string.length / 2;
		String[] array_long = new String[counter];
		int c = 1;
		for (int i = 0; i < counter; i++) {
			array_long[i] = array_string[c];
			c = c + 2;
		}
		return array_long;
	}
}
