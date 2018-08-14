package com.springmvc.datajpa.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.datajpa.entity.Cliente;
import com.springmvc.datajpa.repository.IClienteRepository;

@Controller
public class ClienteController {
	
	/* Inyectamos el repositorio */
	@Autowired
	private IClienteRepository clienteRepository;
	
	/*
	 * LISTAR LOS CLIENTES: Importamos la clase Model para pasar los datos a la
	 * vista
	 *
	 * method = RequestMethod.GET es opcional cuando es get
	 */
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listarClientes(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteRepository.findAll());
		/* Devolvemos el nombre de la vista */
		return "listarClientes";
		
	}
	
	/*
	 * Método que muestra el formulario en el que se rellenan los datos del cliente
	 * que se va a guardar en base de datos (/form --> url)
	 */
	@RequestMapping(value = "/form")
	public String formInsertCliente(Map<String, Object> model) {
		/*
		 * La entidad Cliente está mapeada a la base de datos y a la vista del
		 * formulario, por tanto es bidireccional
		 */
		Cliente c = new Cliente();
		model.put("cliente", c);
		model.put("titulo", "Listado de Clientes");
		/* form --> nombre de la vista */
		return "form";
	}
	
	/*
	 * Después de mostrar el formulario del método formInsertCliente, el siguiente
	 * paso es enviar los datos y procesarlos.
	 * 
	 * /form --> url del formulario
	 * 
	 * @Valid --> Validamos los atributos del objeto cliente
	 * 
	 * BindingResult --> Evalua si el resultado contiene errores
	 * 
	 */
	@PostMapping("/form")
	public String insertarCliente(@Valid Cliente c, BindingResult result, Model model) {
		
		/* Si el formulario contiene errores, redirigimos a la vista del formulario */
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Listado de Clientes");
			return "form";
		}
		
		clienteRepository.save(c);
		/*
		 * Una vez insertado el cliente en base de datos, redirige al usuario a la vista
		 * listar con el listado de clientes
		 */
		return "redirect:listar";
	}
}
