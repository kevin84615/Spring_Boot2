package com.tuyano.springboot;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpServletRequest; 

import com.tuyano.springboot.repositories.MyDataRepository;

@Controller
public class HeloController {
	
	@Autowired
	MyDataRepository repository;
	
	@PersistenceContext
	EntityManager entityManager; //●
	
	MyDataDaoImpl dao; //●
	
	@PostConstruct
	public void init(){
		dao = new MyDataDaoImpl(entityManager); //●
		MyData d1 = new MyData();
		d1.setId(1);
		d1.setName("tuyano");
		d1.setAge(123);
		d1.setMail("syoda@tuyano.com");
		d1.setMemo("090999999");
		repository.saveAndFlush(d1);
		MyData d2 = new MyData();
		d2.setId(2);
		d2.setName("hanako");
		d2.setAge(15);
		d2.setMail("hanako@flower");
		d2.setMemo("080888888");
		repository.saveAndFlush(d2);
		MyData d3 = new MyData();
		d3.setId(3);
		d3.setName("sachiko");
		d3.setAge(37);
		d3.setMail("sachico@happy");
		d3.setMemo("070777777");
		repository.saveAndFlush(d3);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title","Find Page");
		mav.addObject("msg","MyDataのサンプルです。");
		Iterable<MyData> list = dao.findByAge(1, 200);//repository.findAllOrderByName(); //dao.getAll(); //●
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView find(ModelAndView mav) {
		mav.setViewName("find");
		mav.addObject("title","Find Page");
		mav.addObject("msg","MyDataのサンプルです。");
		mav.addObject("value","");
		Iterable<MyData> list = dao.getAll(); //●
		mav.addObject("datalist", list);
		return mav;
	}
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public ModelAndView search(HttpServletRequest request,
			ModelAndView mav) {
		mav.setViewName("find");
		String param = request.getParameter("fstr");
		if (param == ""){
			mav = new ModelAndView("redirect:/find");
		} else {
			mav.addObject("title","Find result");
			mav.addObject("msg","「" + param + "」の検索結果");
			mav.addObject("value",param);
			List<MyData> list = dao.find(param);
			mav.addObject("datalist", list);
		}
		return mav;
	}

}