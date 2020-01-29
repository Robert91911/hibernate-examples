package org.madrid.Metro.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estacion database table.
 * 
 */
@Entity
@Table(name="estacion")
@NamedQuery(name="Estacion.findAll", query="SELECT e FROM Estacion e")
public class Estacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int estacionId;

	private String direccion;

	private String nombre;

	private int numAccesos;

	private int numLineas;

	private int numViajesDestino;

	private int numViajesProcedencia;

	//bi-directional many-to-one association to Acceso
	@OneToMany(mappedBy="estacion")
	private List<Acceso> accesos;

	//bi-directional many-to-one association to LineaEstacion
	@OneToMany(mappedBy="estacion")
	private List<LineaEstacion> lineaEstaciones;

	//bi-directional many-to-one association to Viaje
	@OneToMany(mappedBy="estacionOri")
	private List<Viaje> viajesOri;

	//bi-directional many-to-one association to Viaje
	@OneToMany(mappedBy="estacionDes")
	private List<Viaje> viajesDes;

	public Estacion() {
	}

	public int getEstacionId() {
		return this.estacionId;
	}

	public void setEstacionId(int estacionId) {
		this.estacionId = estacionId;
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

	public int getNumAccesos() {
		return this.numAccesos;
	}

	public void setNumAccesos(int numAccesos) {
		this.numAccesos = numAccesos;
	}

	public int getNumLineas() {
		return this.numLineas;
	}

	public void setNumLineas(int numLineas) {
		this.numLineas = numLineas;
	}

	public int getNumViajesDestino() {
		return this.numViajesDestino;
	}

	public void setNumViajesDestino(int numViajesDestino) {
		this.numViajesDestino = numViajesDestino;
	}

	public int getNumViajesProcedencia() {
		return this.numViajesProcedencia;
	}

	public void setNumViajesProcedencia(int numViajesProcedencia) {
		this.numViajesProcedencia = numViajesProcedencia;
	}

	public List<Acceso> getAccesos() {
		return this.accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public Acceso addAcceso(Acceso acceso) {
		getAccesos().add(acceso);
		acceso.setEstacion(this);

		return acceso;
	}

	public Acceso removeAcceso(Acceso acceso) {
		getAccesos().remove(acceso);
		acceso.setEstacion(null);

		return acceso;
	}

	public List<LineaEstacion> getLineaEstaciones() {
		return this.lineaEstaciones;
	}

	public void setLineaEstaciones(List<LineaEstacion> lineaEstaciones) {
		this.lineaEstaciones = lineaEstaciones;
	}

	public LineaEstacion addLineaEstacione(LineaEstacion lineaEstacione) {
		getLineaEstaciones().add(lineaEstacione);
		lineaEstacione.setEstacion(this);

		return lineaEstacione;
	}

	public LineaEstacion removeLineaEstacione(LineaEstacion lineaEstacione) {
		getLineaEstaciones().remove(lineaEstacione);
		lineaEstacione.setEstacion(null);

		return lineaEstacione;
	}

	public List<Viaje> getViajesOri() {
		return this.viajesOri;
	}

	public void setViajesOri(List<Viaje> viajesOri) {
		this.viajesOri = viajesOri;
	}

	public Viaje addViajesOri(Viaje viajesOri) {
		getViajesOri().add(viajesOri);
		viajesOri.setEstacionOri(this);

		return viajesOri;
	}

	public Viaje removeViajesOri(Viaje viajesOri) {
		getViajesOri().remove(viajesOri);
		viajesOri.setEstacionOri(null);

		return viajesOri;
	}

	public List<Viaje> getViajesDes() {
		return this.viajesDes;
	}

	public void setViajesDes(List<Viaje> viajesDes) {
		this.viajesDes = viajesDes;
	}

	public Viaje addViajesDe(Viaje viajesDe) {
		getViajesDes().add(viajesDe);
		viajesDe.setEstacionDes(this);

		return viajesDe;
	}

	public Viaje removeViajesDe(Viaje viajesDe) {
		getViajesDes().remove(viajesDe);
		viajesDe.setEstacionDes(null);

		return viajesDe;
	}

	@Override
	public String toString() {
		return "Estacion [estacionId=" + estacionId + ", direccion=" + direccion + ", nombre=" + nombre
				+ ", numAccesos=" + numAccesos + ", numLineas=" + numLineas + ", numViajesDestino=" + numViajesDestino
				+ ", numViajesProcedencia=" + numViajesProcedencia + "]";
	}
	
	
}