/**
 * 
 */
package com.springmvc.datajpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

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
 */

/**
 * public interface IClienteRepository extends CrudRepository<Cliente, Long> {
 * 
 * }
 */

/**
 * PagingAndSortingRepository extiende de CrudRepository, con lo que se
 * mantienen los métodos del crud (save,delete,findOne,findAll) y se incluyen
 * además findAll(con sort para ordenar) y findAll (con Pageable para paginar)
 * 
 */
public interface IClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
	
}