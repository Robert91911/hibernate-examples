package org.madrid.Metro.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acceso database table.
 * 
 */
@Entity
@Table(name="acceso")
@NamedQuery(name="Acceso.findAll", query="SELECT a FROM Acceso a")
public class Acceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accesoId;

	private String descripcion;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="estacionId")
	private Estacion estacion;

	public Acceso() {
	}

	public int getAccesoId() {
		return this.accesoId;
	}

	public void setAccesoId(int accesoId) {
		this.accesoId = accesoId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estacion getEstacion() {
		return this.estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

}