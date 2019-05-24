package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");

		mv.addObject("now", new Date().toString());

		return mv;
	}

	// POST用のパラメータを受け取る
	@RequestMapping(value = { "/formPost" }, method = { RequestMethod.POST })
	public ModelAndView postTest1(@RequestParam(value = "user_id", required = true) String user_id,
			@RequestParam(value = "password", required = true) String password) {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("post");

		// modelに設定して画面に表示するようにする
		mv.addObject("user_id", user_id);
		mv.addObject("password", password);

		return mv;
	}

	// GET用のパラメータを受け取る
	@RequestMapping(value = { "/formPost" }, method = { RequestMethod.GET })
	public ModelAndView getTest1(@RequestParam(value = "user_id", required = true) String user_id,
			@RequestParam(value = "password", required = true) String password) {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("post");

		// modelに設定して画面に表示するようにする
		mv.addObject("user_id", user_id);
		mv.addObject("password", password);

		return mv;
	}

	// POST用のパラメータを受け取る
	@RequestMapping(value = { "/new" }, method = { RequestMethod.POST })
	public ModelAndView postTest2() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("new");

		return mv;
	}

	// GET用のパラメータを受け取る
	@RequestMapping(value = { "/new" }, method = { RequestMethod.GET })
	public ModelAndView getTest2() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("new");

		return mv;
	}

	// POST用のパラメータを受け取る
	@RequestMapping(value = { "/result" }, method = { RequestMethod.POST })
	public ModelAndView postTest3() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("result");

		return mv;
	}

}
