package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value = {"/"}, method = {RequestMethod.GET})
	public ModelAndView index() {
		
		// 生成
		ModelAndView mv = new ModelAndView();
		
		// テンプレートを指定
		mv.setViewName("index");
		
		// 日時を取得、設定
		mv.addObject("now", new Date().toString());
		
		// 返却
		return mv;
	}
	
	// POST用のパラメータを受け取る
	@RequestMapping(value = {"/formPost"}, method = {RequestMethod.POST})
	public ModelAndView postTest1(
			@RequestParam(value="name", required = true) String name,
			@RequestParam(value="age", required = true) String age) {
		
		// 生成
		ModelAndView mv = new ModelAndView();
		
		// テンプレートを指定
		mv.setViewName("post");
		
		// modelに設定して画面に表示するようにする
		mv.addObject("name", name);
		mv.addObject("age", age);
		
		// 返却
		return mv;
	}
	
	// GET用のパラメータを受け取る
	@RequestMapping(value = {"/formPost"}, method = {RequestMethod.GET})
	public ModelAndView getTest1(
			@RequestParam(value="name", required = true) String name,
			@RequestParam(value="age", required = true) String age) {
		
		// 生成
		ModelAndView mv = new ModelAndView();
		
		// テンプレートを指定
		mv.setViewName("post");
		
		// modelに設定して画面に表示するようにする
		mv.addObject("name", name);
		mv.addObject("age", age);
		
		// 返却
		return mv;
	}
	
}

