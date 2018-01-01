package com.mf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mf.model.TodoItem;
import com.mf.model.TodoModel;
import com.mf.service.TodoService;

@Controller
@RequestMapping("/")
public class TodoController {
	@Autowired
	TodoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(ModelMap map) {
		 map.addAttribute("list", service.getAll());
		 map.addAttribute("todo", new TodoModel());
		return "Test";
	}
	@RequestMapping(method= RequestMethod.POST)
	public String SaveData(@Valid @ModelAttribute TodoModel model,BindingResult result,ModelMap map) {
		if(result.hasErrors()) {
			home(map);
			return "Test";
		}
		boolean check = service.saveData(model);
		if (check) {
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "move/{id}/{item}")
	public String progress(@PathVariable("id") String id) {
		long newId=Long.valueOf(id);
		boolean check = service.Move(newId);
		if (check) {
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	
	
}
