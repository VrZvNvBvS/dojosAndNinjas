package com.nguyen.dojosAndNinjas.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nguyen.dojosAndNinjas.models.Dojo;
import com.nguyen.dojosAndNinjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoService;

	@GetMapping("/dojos/new")
	public String getNewDojos(
			Model model,
			@ModelAttribute("dojo") Dojo dojo) {
		model.addAttribute("allDojos", dojoService.fetchAllDojos());
		return "newDojos.jsp";
	}
	
	@GetMapping("/dojos")
	public String getDojos(
			Model model,
			@ModelAttribute("dojo") Dojo dojo) {
		model.addAttribute("allDojos", dojoService.fetchAllDojos());
		return "dojos.jsp";
	}
	
	@PostMapping("/dojos/insert")
	public String insertDojo(
			Model model,
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("allDojos", dojoService.fetchAllDojos());
			return "dojos.jsp";
		}
		
		dojoService.saveDojo(dojo);
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(
			Model model,
			@PathVariable("id") Long id) {
		model.addAttribute("dojo", dojoService.fetchOneDojo(id));
		return "showDojos.jsp";
	}

}
