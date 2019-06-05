package com.todo.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
//	@RequestMapping("/abc")
//	public ModelAndView index (ModelAndView mav){
//		mav.setViewName("index");
//		return mav;
//	}	
	@RequestMapping("/other")
	public String other (){
		return "redirect:/";
	}
//	@RequestMapping("/add")
//	public String addd (){
//
//		return "forward:/add";
//	}
	@RequestMapping("/jump_to_add")
	public String add (){
		return "redirect:/add";
	}
	@RequestMapping("/jump_to_delete")
	public String delete (){
		return "redirect:/delete";
	}
}
