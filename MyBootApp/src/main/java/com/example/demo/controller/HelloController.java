package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.*;
import com.example.demo.repositories.UserRepository;

@Controller
public class HelloController {
	
//	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
//	public ModelAndView index() {
//
//		ModelAndView mav = new ModelAndView();
//
//		mav.setViewName("index");
//
//		mav.addObject("now", new Date().toString());
//
//		return mav;
//	}

	// POST用のパラメータを受け取る
	@Autowired
	UserRepository repository;
	
	@RequestMapping(value = { "/formPost" }, method = { RequestMethod.POST })
	public ModelAndView member_POST(@RequestParam(value = "userid", required = true) String userid,
			@RequestParam(value = "password", required = true) String password) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("post");
		mav.addObject("userid", userid);
		mav.addObject("password", password);
		Iterable<UserEntity> list = repository.findAll();
		mav.addObject("data",list);

		return mav;
	}

	// GET用のパラメータを受け取る
	@RequestMapping(value = { "/formPost" }, method =  RequestMethod.GET )
	public ModelAndView member_GET(@RequestParam(value = "userid", required = true) String userid,
			@RequestParam(value = "password", required = true) String password) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("post");
		mav.addObject("userid", userid);
		mav.addObject("password", password);
		Iterable<UserEntity> list = repository.findAll();
		mav.addObject("data",list);

		return mav;
	}

	@RequestMapping(value = { "/result" }, method =  RequestMethod.POST )
	@Transactional(readOnly=false)
	public ModelAndView form(@ModelAttribute("formModel") UserEntity user,ModelAndView mav){

		repository.saveAndFlush(user);
		return mav;
	}

	// POST用のパラメータを受け取る
	@RequestMapping(value = { "/user" }, method = { RequestMethod.POST })
	public ModelAndView create_POST() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("new");
		return mav;
	}

	// GET用のパラメータを受け取る
	@RequestMapping(value = { "/user" }, method = { RequestMethod.GET })
	public ModelAndView create_GET() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("new");
		return mav;
	}

}
