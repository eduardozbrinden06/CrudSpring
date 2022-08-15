package com.example.crudclientes.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crudclientes.interfaceService.IClienteService;
import com.example.crudclientes.modelo.Clientes;


@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Clientes>clientes=service.listar();
		model.addAttribute("clientes", clientes);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("clientes", new Clientes());
		return "FormCrear";
	}
	
	@PostMapping("/save")
	public String save(@Validated Clientes c, Model model) {
		service.save(c);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Clientes>clientes=service.listarId(id);
		model.addAttribute("clientes", clientes);
		return "FormCrear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	

}
