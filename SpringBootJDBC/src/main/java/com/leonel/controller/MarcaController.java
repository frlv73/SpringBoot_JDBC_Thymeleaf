package com.leonel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//Recibe como parámetro el id de la marca. El value del RequestMapping indica desde que url se solicita el método
	@RequestMapping(value="detalle/{id}", method = RequestMethod.GET)
	public String detalle(@PathVariable ("id") int id,  ModelMap modelMap) {
		
		//Busca la marca por id y la pone en la variable
		modelMap.put("marca", service.findMarcaByID(id));
		
		// Abre el archivo detalle
		return "marca/detalle";
	}

}
