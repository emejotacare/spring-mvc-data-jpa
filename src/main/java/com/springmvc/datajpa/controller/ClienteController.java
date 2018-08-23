package com.springmvc.datajpa.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.datajpa.entity.Cliente;
import com.springmvc.datajpa.service.IClienteService;

@Controller
public class ClienteController {
	
	/* Inyectamos el service */
	@Autowired
	private IClienteService clienteService;
	
	/*
	 * LISTAR LOS CLIENTES: Importamos la clase Model para pasar los datos a la
	 * vista
	 *
	 * method = RequestMethod.GET es opcional cuando es get
	 * 
	 * @GetMapping(value = "/listar")
	 * 
	 * @GetMapping("/listar")
	 */
	@RequestMapping("/listar")
	/* public String listarClientes(@RequestParam int page, Model model) { */
	public String listarClientes(Model model) {
		// Pageable pageRequest = PageRequest.of(page, 6);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		// model.addAttribute("clientes", pageRequest);
		return "listarClientes";
		
	}
	
	/*
	 * Método que muestra el formulario en el que se rellenan los datos del cliente
	 * que se va a guardar en base de datos (/form --> url)
	 */
	@GetMapping("/form")
	public String mostrarFormInsert(Model model) {
		/*
		 * La entidad Cliente está mapeada a la base de datos y a la vista del
		 * formulario, por tanto es bidireccional
		 */
		Cliente c = new Cliente();
		model.addAttribute("cliente", c);
		model.addAttribute("titulo", "Listado de Clientes");
		/* form --> nombre de la vista */
		return "form";
	}
	
	/*
	 * Método que muestra el formulario en el que se rellenan los datos del cliente
	 * que se va a guardar en base de datos (/form --> url)
	 */
	@RequestMapping(value = "/form2")
	public String mostrarFormInsert2(Map<String, Object> model) {
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
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String insertarCliente(@Valid Cliente c, BindingResult result, Model model) {
		
		/* Si el formulario contiene errores, redirigimos a la vista del formulario */
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Listado de Clientes");
			return "form";
		}
		
		clienteService.save(c);
		/*
		 * Una vez insertado el cliente en base de datos, redirige al usuario a la vista
		 * listar con el listado de clientes
		 */
		return "redirect:listar";
	}
	
	/* EDITAR */
	@GetMapping("/form/{id}")
	public String editarCliente(@PathVariable(value = "id") Long id, Model model) {
		
		/*
		 * Declaramos el objeto en el que vamos a almacenar el cliente que estamos
		 * buscando en base de datos
		 */
		Cliente c = null;
		
		if (id > 0) {
			c = clienteService.findById(id);
			
		} else {
			return "redirect:/listar";
		}
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("cliente", c);
		return "form";
	}
	
	/*
	 * Eliminar un cliente dado su id.
	 *
	 * @RequestMapping(value = "/clientes/{id}")
	 * 
	 * @RequestMapping("/clientes/{id}")
	 * 
	 */
	@GetMapping("/clientes/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		
		if (id > 0) {
			clienteService.delete(id);
		}
		return "redirect:/listar";
	}
	
}
