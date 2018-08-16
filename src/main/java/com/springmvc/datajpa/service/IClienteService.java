/**
 * 
 */
package com.springmvc.datajpa.service;

import java.util.List;

import com.springmvc.datajpa.entity.Cliente;

/**
 * @author María José
 * 
 *         Por cada método del repositorio, tenemos uno en el service
 *
 */
public interface IClienteService {
	
	/* Método para devolver la lista de clientes */
	public List<Cliente> findAll();
	
	/* Buscar un cliente por id */
	public Cliente findById(Long id);
	
	/* Insertar-Editar nuevo cliente */
	public void save(Cliente cliente);
	
	/* Eliminar un cliente pasando el id */
	public void delete(Long id);
	
}
