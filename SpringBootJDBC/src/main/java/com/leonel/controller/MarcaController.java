package com.leonel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leonel.model.Marca;
import com.leonel.service.IMarcaService;

@Controller
@RequestMapping("marca")
public class MarcaController {
	
	@Autowired
	private IMarcaService service;
	
	//Redirige a la lista de marcas
	@RequestMapping(method = RequestMethod.GET)
	public String lista(ModelMap modelMap) {
		modelMap.put("listaMarcas", service.getAllMarcas());
		modelMap.addAttribute("titulo", "Lista de Marcas");
		
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
	
	//Redirige al formulario para agregar marcas
	@RequestMapping(value="agregar", method=RequestMethod.GET)
	public String marcaform(ModelMap modelMap) {
		modelMap.put("titulo", "Agregar Marca");
		return "marca/marcaForm";
	}
	
	//Agrega la marca cargada en el formulario y redirige a la página con la lista de marcas
	@RequestMapping(value="agregar", method=RequestMethod.POST)
	public String add(@RequestParam("txtID") int id, @RequestParam("txtNombre") String nombre ,ModelMap modelMap) {
		
		//Crea una nueva instancia de marca y le asigna los valores recibidos del form
		Marca m = new Marca();
		m.setId(id);
		m.setNombre(nombre);
		
		//Agrega la marca a la base de datos
		service.addMarca(m);
		
		//Trae todas las marcas otra vez y redirige a la lista
		modelMap.put("listaMarcas", service.getAllMarcas());
		return "marca/lista";
	}

}
