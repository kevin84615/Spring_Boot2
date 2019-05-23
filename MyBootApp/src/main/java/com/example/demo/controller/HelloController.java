package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index (ModelAndView mav){
		mav.setViewName("index");
		mav.addObject("msg", "user");
		return mav;
	}
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send (@RequestParam("text1")String str,ModelAndView mav){
		mav.addObject("msg","hello___" + str +"!!");
		mav.addObject("value", str);
		mav.setViewName("Todo");
		return mav;
	}	
}


