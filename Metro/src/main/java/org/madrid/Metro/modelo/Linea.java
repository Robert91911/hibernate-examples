package org.madrid.Metro.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the linea database table.
 * 
 */
@Entity
@Table(name="linea")
@NamedQuery(name="Linea.findAll", query="SELECT l FROM Linea l")
public class Linea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lineaId;

	private String nombre;

	//bi-directional many-to-one association to LineaEstacion
	@OneToMany(mappedBy="linea")
	private List<LineaEstacion> lineaEstaciones;

	//bi-directional many-to-one association to Tren
	@OneToMany(mappedBy="linea")
	private List<Tren> trenes;

	public Linea() {
	}

	public int getLineaId() {
		return this.lineaId;
	}

	public void setLineaId(int lineaId) {
		this.lineaId = lineaId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LineaEstacion> getLineaEstaciones() {
		return this.lineaEstaciones;
	}

	public void setLineaEstaciones(List<LineaEstacion> lineaEstaciones) {
		this.lineaEstaciones = lineaEstaciones;
	}

	public LineaEstacion addLineaEstacione(LineaEstacion lineaEstacione) {
		getLineaEstaciones().add(lineaEstacione);
		lineaEstacione.setLinea(this);

		return lineaEstacione;
	}

	public LineaEstacion removeLineaEstacione(LineaEstacion lineaEstacione) {
		getLineaEstaciones().remove(lineaEstacione);
		lineaEstacione.setLinea(null);

		return lineaEstacione;
	}

	public List<Tren> getTrenes() {
		return this.trenes;
	}

	public void setTrenes(List<Tren> trenes) {
		this.trenes = trenes;
	}

	public Tren addTrene(Tren trene) {
		getTrenes().add(trene);
		trene.setLinea(this);

		return trene;
	}

	public Tren removeTrene(Tren trene) {
		getTrenes().remove(trene);
		trene.setLinea(null);

		return trene;
	}

}