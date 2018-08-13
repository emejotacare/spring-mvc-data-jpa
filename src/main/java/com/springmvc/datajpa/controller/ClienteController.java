package com.springmvc.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.datajpa.repository.IClienteRepository;

@Controller
public class ClienteController {
	
	/* Inyectamos el repositorio */
	@Autowired
	private IClienteRepository clienteRepository;
	
	/*
	 * LISTAR LOS CLIENTES: Importamos la clase Model para pasar los datos a la
	 * vista
	 */
	
	/* method = RequestMethod.GET es opcional cuando es get */
	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public String listarClientes(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteRepository.findAll());
		/* Devolvemos el nombre de la vistsa */
		return "listarClientes";
		
	}
	
}
