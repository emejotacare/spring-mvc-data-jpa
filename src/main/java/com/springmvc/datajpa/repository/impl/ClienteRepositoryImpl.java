package com.springmvc.datajpa.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.datajpa.entity.Cliente;
import com.springmvc.datajpa.repository.IClienteRepository;

@Repository
public class ClienteRepositoryImpl implements IClienteRepository {
	
	// Gestiona las entidades
	@PersistenceContext
	private EntityManager em;
	
	// Listado de clientes
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}
	
	/* Buscar un cliente por id */
	@Override
	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
	
	/* Insertar-Editar nuevo cliente */
	@Override
	@Transactional
	public void save(Cliente cliente) {
		/*
		 * Si el id existe y es >0, inserta el cliente en bd, si no, actualiza sus datos
		 * en bd
		 */
		if (cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		} else {
			/*
			 * persist -->Almacena el objeto entidad en el contexto de persistencia y BD
			 * haciendo el insert en la tabla
			 */
			em.persist(cliente);
		}
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		/* Obtenemos el cliente de bd pasando el id */
		Cliente cliente = findById(id);
		/* Lo eliminamos con el em */
		em.remove(cliente);
	}
	
}
