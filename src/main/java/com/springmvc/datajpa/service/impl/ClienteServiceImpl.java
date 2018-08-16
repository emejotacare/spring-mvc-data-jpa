package com.springmvc.datajpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.datajpa.entity.Cliente;
import com.springmvc.datajpa.repository.IClienteRepository;
import com.springmvc.datajpa.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	/*
	 * Inyectamos el repositorio
	 */
	@Autowired
	private IClienteRepository clienteRepository;
	
	/*
	 * Método para devolver la lista de clientes
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	/* Buscar un cliente por id */
	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id);
	}
	
	/* Insertar-Editar nuevo cliente */
	@Override
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}
	
	/* Eliminar un cliente pasando el id */
	@Override
	public void delete(Long id) {
		clienteRepository.delete(id);
	}
	
}
