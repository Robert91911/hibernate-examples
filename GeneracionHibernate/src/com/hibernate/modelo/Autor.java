package com.hibernate.modelo;

import java.util.Date;


public class Autor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String apellidos;
	private Date fecha;
	private Boolean publicacion;

	public Autor() {
	}

	public Autor(String nombre, String apellidos, Date fecha,
			Boolean publicacion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.publicacion = publicacion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Boolean publicacion) {
		this.publicacion = publicacion;
	}

}
