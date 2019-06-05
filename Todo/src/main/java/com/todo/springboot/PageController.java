package com.todo.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PageController {
	@RequestMapping("/other")
	public String other (){
		return "redirect:/";
	}
	@RequestMapping("/jump_to_add")
	public String add (){
		return "redirect:/add";
	}
	@RequestMapping("/edit/other")
	public String delete (){
		return "redirect:/";
	}
}
