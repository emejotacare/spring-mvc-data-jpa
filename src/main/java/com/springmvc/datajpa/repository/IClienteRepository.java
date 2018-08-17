/**
 * 
 */
package com.springmvc.datajpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.springmvc.datajpa.entity.Cliente;

/**
 * @author María José
 * 
 *         CrudRepository --> Interfaz propia de Spring data que implementa los
 *         métodos básicos para hacer un crud.
 * 
 *         Cliente --> Entidad
 * 
 *         Long --> Tipo de dato de la primary key en la clase (entidad) Cliente
 *
 */
public interface IClienteRepository extends CrudRepository<Cliente, Long> {
	
}
