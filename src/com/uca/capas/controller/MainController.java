package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class MainController {
	
	//Objeto Logger
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			students = studentDao.findAll();
		}
		catch(Exception e) {
			log.log(Level.SEVERE,"Exception Occur",e);
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/update")
	public ModelAndView update(@RequestParam("cStudent") Integer cstudent) {
		ModelAndView mav = new ModelAndView();
		Student student = null;
		try {
			student = studentDao.findOne(cstudent);
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		mav.addObject("student", student);
		mav.setViewName("update");
		return mav;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", new Student());
		mav.setViewName("form");
		return mav;
	}
	
	
	@RequestMapping(value="/guardar",method=RequestMethod.POST)
	public ModelAndView modificar(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> student = null;

		try {
			studentDao.update(s);
			student = studentDao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("students", student);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/formData")
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> student = null;
		try {
			studentDao.save(s, 1);
		}catch(Exception e) {
			log.info("Error"+e.toString());
		}
		student=studentDao.findAll();
		log.info(student.get(0).getlName());
		mav.addObject("students", student);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView formData(@RequestParam(value ="cStudent")Integer cStudent) {
		ModelAndView mav = new ModelAndView();
		List<Student> student = null;
		try {
			log.info("dato"+ cStudent);
			studentDao.delete(cStudent);
			log.info("despues de eliminar");
			student = studentDao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("students", student);
		mav.setViewName("main");
		return mav;
	}
}
