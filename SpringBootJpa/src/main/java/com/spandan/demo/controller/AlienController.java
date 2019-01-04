package com.spandan.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spandan.demo.dao.AlienRepo;
import com.spandan.demo.model.Alien;

@RestController
@ResponseBody
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
	
	/**
	 *  Jackson-core is responsible to convert java onject to JSON 
	 *  */
	
	@RequestMapping("/aliens")
	public List<Alien> getAllAlien() {
		return repo.findAll();


	}
	
	@RequestMapping("/alien/{aid}")
	
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);

	}
	
	
}
