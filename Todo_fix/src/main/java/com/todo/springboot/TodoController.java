package com.todo.springboot;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.todo.springboot.repositories.TodoRepository;

@Controller
public class TodoController {

	@Autowired
	TodoRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute TodoData tododata, ModelAndView mav) {
		mav.setViewName("index");
		Iterable<TodoData> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav) {
		mav.setViewName("add");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView upload(@ModelAttribute TodoData tododata, ModelAndView mav) {
		tododata.setCreatedDate(Get.time());
		tododata.setUploadDate(Get.time());
		repository.saveAndFlush(tododata);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit/{todoid}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute TodoData tododata, @PathVariable int todoid, ModelAndView mav,
			String created_date, String user_id) {
		mav.setViewName("edit");
		Optional<TodoData> data = repository.findById((long) todoid);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView update(@ModelAttribute TodoData tododata, ModelAndView mav) {
		tododata.setUploadDate(Get.time());
		repository.saveAndFlush(tododata);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView remove(@ModelAttribute("formModel") TodoData tododata, ModelAndView mav) {
		mav.setViewName("delete");
		Optional<TodoData> data = repository.findById(tododata.getTodoID());
		mav.addObject("formModel", data.get());
		
		return mav;
	}

	@RequestMapping(value = "/deleteEnd", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView removeconfirm(TodoData tododata, ModelAndView mav) {
		repository.deleteById(tododata.getTodoID());
		return new ModelAndView("redirect:/");
	}
}