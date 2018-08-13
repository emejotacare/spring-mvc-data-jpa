package com.springmvc.datajpa.repository;

import java.util.List;

import com.springmvc.datajpa.entity.Cliente;

public interface IClienteRepository {
	
	/* Método para devolver la lista de clientes */
	public List<Cliente> findAll();
	
	/* Insertar nuevo cliente */
	public void save(Cliente cliente);
	
}
