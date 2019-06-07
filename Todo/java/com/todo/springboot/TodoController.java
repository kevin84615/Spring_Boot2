package com.todo.springboot;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time = sdf.format(timestamp);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("formModel") TodoData mydata, ModelAndView mav) {
		mav.setViewName("index");
		Iterable<TodoData> list = repository.findAll();
		ArrayList<String> Convert_Date = new ArrayList<>();
		Convert_Date = DateConvert.Date(list,Convert_Date);
		mav.addObject("datalist", list);
		mav.addObject("Date",Convert_Date);
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav) {
		mav.setViewName("add");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView upload(@ModelAttribute TodoData mydata, ModelAndView mav) {
		mydata.setCreatedDate(time);
		mydata.setUploadDate(time);
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit/{todoid}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute TodoData mydata, @PathVariable int todoid, ModelAndView mav,
			String created_date, String user_id) {
		mav.setViewName("edit");
		mav.addObject("title", "edit mydata.");
		Optional<TodoData> data = repository.findById((long) todoid);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView update(@ModelAttribute TodoData mydata, ModelAndView mav) {
		mydata.setUploadDate(time);
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView remove(@ModelAttribute("formModel") TodoData mydata,
			ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title", "delete mydata.");
		Long[]todoID = MultipleDelete.todo_id(mydata);
		Optional<TodoData> data = repository.findById((long) todoID[0]);
		mav.addObject("formModel", data.get());
		mav.addObject("multiple", mydata.getMultiple());
		return mav;
	}

	@RequestMapping(value = "/deleteEnd", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView removeconfirm(TodoData mydata,ModelAndView mav) {
		Long[]todoID = MultipleDelete.todo_id(mydata);
		for(long delete_counter : todoID) {
			repository.deleteById(delete_counter);
		}
		return new ModelAndView("redirect:/");
	}
}