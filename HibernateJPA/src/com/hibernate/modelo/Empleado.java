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
 * Clase simple que representa un Empleado
 * javax.persistence.Entity anotación se utiliza para señalizar a hibernate que
 * esta clase la puede hacer persistente.
 * javax.persistence.Table anotación se utiliza para definir el mapeo de tabla y definir restricciones de unicidad.
 * javax.persistence.Id anotación se usa para definir la clave primaria. 
 * javax.persistence.GeneratedValue se usa para definir que este campo es autogenerado 
 * y GenerationType.IDENTITY strategy se usa para mapear el valor autogenerado "id" y que pueda ser recuperado en el POJO por java.
 * javax.persistence.Column anotación se usa para mapear el atributo con una columna de la tabla:
 * podemos especificar longitud, nullable y unicidad para las columnas.
 *
 */
@Entity
@Table(name="Empleado", 
       uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Empleado {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
	private int id;
	@Column(name="nombre", length=20, nullable=true)
	private String nombre;
	@Column(name="rol", length=20, nullable=true)
	private String rol;
	@Column(name="fecha", nullable=true)
	private Date fecha;
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
