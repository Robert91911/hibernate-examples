package ejercicios2.ejercicio7;

import java.io.Serializable;

public class Modulo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String nombre;

	private float creditos;

	public Modulo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCreditos() {
		return creditos;
	}

	public void setCreditos(float creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Modulo [idModulo=" + id + ", nombre=" + nombre
				+ ", creditos=" + creditos + "]";
	}
	
	

}
