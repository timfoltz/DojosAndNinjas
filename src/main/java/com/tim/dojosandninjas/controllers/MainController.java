package com.tim.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tim.dojosandninjas.models.Dojo;
import com.tim.dojosandninjas.models.Ninja;
import com.tim.dojosandninjas.services.DojoService;
import com.tim.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
//	******root******
	@GetMapping("/")
	private String index(Model model) {
		return "redirect:/dojos/new";
	}
//	******Create******
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newDojo.jsp";
	}
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo")Dojo dojo, 
							BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result);
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			Dojo dojo = ninja.getDojo();
			Long id = dojo.getId();
			

			return "redirect:/dojos/"+id;
		}
	}

	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id")Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "oneDojo.jsp";
	}
}
