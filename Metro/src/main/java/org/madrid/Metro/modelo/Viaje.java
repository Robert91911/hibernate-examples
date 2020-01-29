package org.madrid.Metro.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the viaje database table.
 * 
 */
@Entity
@Table(name="viaje")
@NamedQuery(name="Viaje.findAll", query="SELECT v FROM Viaje v")
public class Viaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int viajeId;

	private String nombre;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="estacionOrigen")
	private Estacion estacionOri;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="estacionDestino")
	private Estacion estacionDes;

	public Viaje() {
	}

	public int getViajeId() {
		return this.viajeId;
	}

	public void setViajeId(int viajeId) {
		this.viajeId = viajeId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estacion getEstacionOri() {
		return this.estacionOri;
	}

	public void setEstacionOri(Estacion estacionOri) {
		this.estacionOri = estacionOri;
	}

	public Estacion getEstacionDes() {
		return this.estacionDes;
	}

	public void setEstacionDes(Estacion estacionDes) {
		this.estacionDes = estacionDes;
	}

}