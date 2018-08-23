package com.springmvc.datajpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	 * 
	 * (List<Cliente>) --> Casting porque clienteRepository.findAll() devuelve un
	 * Iterable.
	 * 
	 * 
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	@Override
	public Page<Cliente> findAll(Pageable p) {
		return clienteRepository.findAll(p);
	}
	
	/*
	 * Buscar un cliente por id.
	 * 
	 * orElse --> Devuelve el objeto entity encontrado o null si viene vacío
	 * 
	 */
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	/* Insertar-Editar nuevo cliente */
	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}
	
	/* Eliminar un cliente pasando el id */
	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}
	
}
