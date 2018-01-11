package com.leonel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leonel.service.IMarcaService;

@Controller
@RequestMapping("marca")
public class MarcaController {
	
	@Autowired
	private IMarcaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String lista(ModelMap modelMap) {
		modelMap.put("listaMarcas", service.getAllMarcas());
		return "marca/lista";
	}

}
