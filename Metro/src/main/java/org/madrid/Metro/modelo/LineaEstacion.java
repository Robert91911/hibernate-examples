package org.madrid.Metro.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the linea_estacion database table.
 * 
 */
@Entity
@Table(name="linea_estacion")
@NamedQuery(name="LineaEstacion.findAll", query="SELECT l FROM LineaEstacion l")
public class LineaEstacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LineaEstacionPK id;

	private int orden;

	//bi-directional many-to-one association to Linea
	@ManyToOne
	@JoinColumn(name="lineaId")
	private Linea linea;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="estacionId")
	private Estacion estacion;

	public LineaEstacion() {
	}

	public LineaEstacionPK getId() {
		return this.id;
	}

	public void setId(LineaEstacionPK id) {
		this.id = id;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public Linea getLinea() {
		return this.linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Estacion getEstacion() {
		return this.estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

}