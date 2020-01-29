package com.hibernate.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Clase Autor con anotaciones JPA
 * 
 */
@Entity
@Table(name="Autor", 
       uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Autor {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
	private int id;
	@Column(name="NOMBRE", length=20, nullable=true)
	private String nombre;
	@Column(name="APELLIDOS", length=20, nullable=true)
	private String apellidos;
	@Column(name="FECHA", nullable=true)
	private Date fecha;
	@Column(name="PUBLICACION", nullable=false)
	private boolean publicacion;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isPublicacion() {
		return publicacion;
	}
	public void setPublicacion(boolean publicacion) {
		this.publicacion = publicacion;
	}
	
	
}
