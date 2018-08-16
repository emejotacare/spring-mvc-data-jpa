package com.springmvc.datajpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The Class Cliente.
 *
 * @author María José
 * 
 *         implements Serializable no es obligatorio pero sí una buena práctica
 *         para trabajar con MVC o JPA
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = -6605655713808923783L;
	
	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	/**
	 * The nombre.
	 */
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;
	
	/**
	 * The apellido.
	 */
	@Column(name = "apellido")
	@NotEmpty
	private String apellido;
	
	/**
	 * The email.
	 */
	@Column(name = "email")
	@NotEmpty
	@Email
	private String email;
	
	/**
	 * The create at.
	 */
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date createAt;
	
	/** MÉTODOS */
	
	/**
	 * @PrePersist: Asignar la fecha de creación del objeto entidad antes de
	 *              persistirlo en base de datos
	 * 
	 * @PrePersist public void prePersist() { createAt = new Date(); }
	 */
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Sets the apellido.
	 *
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the creates the at.
	 *
	 * @return the createAt
	 */
	public Date getCreateAt() {
		return createAt;
	}
	
	/**
	 * Sets the creates the at.
	 *
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
}
