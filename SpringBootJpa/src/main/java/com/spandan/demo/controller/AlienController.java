package com.spandan.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spandan.demo.dao.AlienRepo;
import com.spandan.demo.model.Alien;

@RestController
//@ResponseBody
public class AlienController {
	
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien) {
//		
//		repo.save(alien);
//		return "home.jsp";
//	}
	
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
	
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		return alien;
	}
	
	/**
	 *  Jackson-core is responsible to convert java object to JSON 
	 *  Jackson-dataformat-xml to convert java object to XML
	 *  */
	
	@GetMapping(path = "/aliens")
	public List<Alien> getAllAlien() {
		return repo.findAll();


	}
	
	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);

	}
	
	/**
	 *  update example is restricted to accept only json type of data if we use "consumes"
	 */
	
	@PutMapping(path = "/alien", consumes = "application/json")
	public Alien updateAliedn(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "Deleted";
	}
	
}
