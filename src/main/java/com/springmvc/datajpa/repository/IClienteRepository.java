package com.springmvc.datajpa.repository;

import java.util.List;

import com.springmvc.datajpa.entity.Cliente;

public interface IClienteRepository {
	
	/* Método para devolver la lista de clientes */
	public List<Cliente> findAll();
	
	/* Buscar un cliente por id */
	public Cliente findById(Long id);
	
	/* Insertar-Editar nuevo cliente */
	public void save(Cliente cliente);
	
	/* Eliminar un cliente pasando el id */
	public void delete(Long id);
	
}
