package org.madrid.Metro.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cochera database table.
 * 
 */
@Entity
@Table(name="cochera")
@NamedQuery(name="Cochera.findAll", query="SELECT c FROM Cochera c")
public class Cochera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cocheraId;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to Tren
	@OneToMany(mappedBy="cochera")
	private List<Tren> trenes;

	public Cochera() {
	}

	public int getCocheraId() {
		return this.cocheraId;
	}

	public void setCocheraId(int cocheraId) {
		this.cocheraId = cocheraId;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tren> getTrenes() {
		return this.trenes;
	}

	public void setTrenes(List<Tren> trenes) {
		this.trenes = trenes;
	}

	public Tren addTrene(Tren trene) {
		getTrenes().add(trene);
		trene.setCochera(this);

		return trene;
	}

	public Tren removeTrene(Tren trene) {
		getTrenes().remove(trene);
		trene.setCochera(null);

		return trene;
	}

}