package ejercicios1.ejercicio5_8_xml;

import java.util.Arrays;
import java.util.Date;

/**
 *  @description Clase que representa un seguro
 *	@author Laura
 */

public class Seguro {
	
	enum TipoSexo {HOMBRE,MUJER};
	enum TipoSeguro {HOGAR,COCHE,MOTO,VIAJE};
	
	private int idSeguro;
	private String nif;
	private String nombre;
	private String ape1;
	private String ape2;
	private int edad;
	private int numHijos;
	private boolean esMayorEdad;
	private TipoSexo sexo;
	private TipoSeguro tipo;
	private boolean casado;
	private Date fechaCreacion;
	private Date fechaNacimiento;
	private Date horaContacto;
	private char[] claves;
	private String comentarios;
	
	
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe1() {
		return ape1;
	}
	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}
	public String getApe2() {
		return ape2;
	}
	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getNumHijos() {
		return numHijos;
	}
	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}
	public boolean isEsMayorEdad() {
		return esMayorEdad;
	}
	public void setEsMayorEdad(boolean esMayorEdad) {
		this.esMayorEdad = esMayorEdad;
	}
	public TipoSexo getSexo() {
		return sexo;
	}
	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}
	public TipoSeguro getTipo() {
		return tipo;
	}
	public void setTipo(TipoSeguro tipo) {
		this.tipo = tipo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isCasado() {
		return casado;
	}
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getHoraContacto() {
		return horaContacto;
	}
	public void setHoraContacto(Date horaContacto) {
		this.horaContacto = horaContacto;
	}
	public char[] getClaves() {
		return claves;
	}
	public void setClaves(char[] claves) {
		this.claves = claves;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", nif=" + nif + ", nombre="
				+ nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", edad="
				+ edad + ", numHijos=" + numHijos + ", esMayorEdad="
				+ esMayorEdad + ", sexo=" + sexo + ", tipo=" + tipo
				+ ", casado=" + casado + ", fechaCreacion=" + fechaCreacion
				+ ", fechaNacimiento=" + fechaNacimiento + ", horaContacto="
				+ horaContacto + ", claves=" + Arrays.toString(claves)
				+ ", comentarios=" + comentarios + "]";
	}
	
	
	
	
	
	

}


