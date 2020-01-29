package org.madrid.Metro.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tren database table.
 * 
 */
@Entity
@Table(name="tren")
@NamedQuery(name="Tren.findAll", query="SELECT t FROM Tren t")
public class Tren implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int trenId;

	private String nombre;

	private String tipo;

	//bi-directional many-to-one association to Linea
	@ManyToOne
	@JoinColumn(name="lineaId")
	private Linea linea;

	//bi-directional many-to-one association to Cochera
	@ManyToOne
	@JoinColumn(name="cocheraId")
	private Cochera cochera;

	public Tren() {
	}

	public int getTrenId() {
		return this.trenId;
	}

	public void setTrenId(int trenId) {
		this.trenId = trenId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Linea getLinea() {
		return this.linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Cochera getCochera() {
		return this.cochera;
	}

	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}

}