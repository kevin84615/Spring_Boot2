package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping("/")
	public ModelAndView index (ModelAndView mav){
		mav.setViewName("index");
		return mav;
	}	
	@RequestMapping("/other")
	public String other (){

		return "redirect:/";
	}	
//	@RequestMapping("/user")
//	public String user(){
//
//		return "forward:/";
//	}	
}