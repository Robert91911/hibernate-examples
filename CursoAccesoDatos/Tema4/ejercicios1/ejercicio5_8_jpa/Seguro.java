package ejercicios1.ejercicio5_8_jpa;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

/**
 *  @description Clase que representa un seguro
 *	@author Laura
 */

@Entity
@Table(name="Seguro1",uniqueConstraints=@UniqueConstraint(columnNames={"IDSEGURO", "NIF"} ) )
public class Seguro {
	
	enum TipoSexo {HOMBRE,MUJER};
	enum TipoSeguro {HOGAR,COCHE,MOTO,VIAJE};
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDSEGURO", nullable=false, unique=true)
	private int idSeguro;
	
	@Column(name="NIF", nullable=false, unique=true)
	private String nif;
	
	//Fijarse como las columnas no anotadas también se mapean sin necesidad de anotación
	private String nombre;
	
	private String ape1;
	
	private String ape2;
	
	private int edad;
	
	private int numHijos;
	
	@Formula("edad>18")
	private boolean esMayorEdad;
	
	//Como este enumerado lo almaceno como ordinal no me hace falta anotación
	private TipoSexo sexo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPOSEGURO")
	private TipoSeguro tipo;
	
	@Type(type="yes_no")
	private boolean casado;
	
    private Date fechaCreacion;
    
    @Temporal(TemporalType.DATE)
	@Column(name="FECHANACIMIENTO")
    private Date fechaNacimiento;
    
    @Temporal(TemporalType.TIME)
	@Column(name="HORACONTACTO", nullable=false)
	private Date horaContacto;
    
    @Lob
	private char[] claves;
    
    @Lob
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


