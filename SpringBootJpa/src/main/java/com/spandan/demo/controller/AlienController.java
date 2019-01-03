package com.spandan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spandan.demo.dao.AlienRepo;
import com.spandan.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView addAlien(@RequestParam int aid) {
		
		ModelAndView modelAndView = new ModelAndView("showAlien.jsp");
		
		Alien alien = repo.findById(aid).orElse(new Alien());
		modelAndView.addObject(alien);
		
		//find by any property without writing method for that through Spring JPA
		System.out.println(repo.findByTech("Python"));
		
		System.out.println(repo.findByAidGreaterThan(104));
		System.out.println(repo.findByTechSorted("Java"));
		
		return modelAndView;
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAllAlien() {
		System.out.println("hi...");
		return repo.findAll().toString();

	}
	
	
}
