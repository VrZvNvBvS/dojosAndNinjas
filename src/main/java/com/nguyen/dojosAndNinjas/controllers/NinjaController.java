package com.nguyen.dojosAndNinjas.controllers;

import javax.validation.Valid;

import com.nguyen.dojosAndNinjas.models.Ninja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nguyen.dojosAndNinjas.services.DojoService;
import com.nguyen.dojosAndNinjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;

	@GetMapping("/ninjas/new")
	public String getNewNinjas(
			Model model,
			@ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("allNinjas", ninjaService.fetchAllNinjas());
		model.addAttribute("allDojos", dojoService.fetchAllDojos());
		return "newNinjas.jsp";
	}
	
	@GetMapping("/ninjas")
	public String getNinjas(
			Model model,
			@ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("allNinjas", ninjaService.fetchAllNinjas());
		model.addAttribute("allDojos", dojoService.fetchAllDojos());
		return "ninjas.jsp";
	}



	@PostMapping("/ninjas/insert")
	public String insertNinja(
			Model model,
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("allNinjas", ninjaService.fetchAllNinjas());
			model.addAttribute("allDojos", dojoService.fetchAllDojos());
			return "ninjas.jsp";
		}
		ninjaService.saveNinja(ninja);
		return "redirect:/ninjas";
	}

}
