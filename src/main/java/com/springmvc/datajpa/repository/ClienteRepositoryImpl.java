package com.springmvc.datajpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.datajpa.entity.Cliente;

@Repository
public class ClienteRepositoryImpl implements IClienteRepository {
	
	// Gestiona las entidades
	@PersistenceContext
	private EntityManager em;
	
	// Listado de clientes
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}
	
	/* Insertar nuevo cliente */
	@Override
	@Transactional
	public void save(Cliente cliente) {
		/*
		 * persist --> Almacena el objeto entidad en el contexto de persistencia y BD
		 * haciendo el insert en la tabla
		 */
		em.persist(cliente);
	}
	
}
