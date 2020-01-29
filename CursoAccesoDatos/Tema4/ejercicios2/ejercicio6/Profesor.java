package ejercicios2.ejercicio6;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Profesor",uniqueConstraints=@UniqueConstraint(columnNames={"ID"} ) )
public class Profesor implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="ape1")
    private String ape1;
    
    @Column(name="ape2")    
    private String ape2;
    
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "DIRECCION_ID") //Columna para el join de Direccion
    private Direccion direccion;
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MODULO_ID") //Columna para el join	 
    private Modulo modulo;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="PROFESOR_ID",nullable=false)
	@OrderColumn(name="correos_index")
	private List<Correo> correos;

    public Profesor(){ 
    }

    public Profesor(int id, String nombre, String ape1, String ape2) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
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
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ape1
     */
    public String getApe1() {
        return ape1;
    }

    /**
     * @param ape1 the ape1 to set
     */
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    /**
     * @return the ape2
     */
    public String getApe2() {
        return ape2;
    }

    /**
     * @param ape2 the ape2 to set
     */
    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Correo> getCorreos() {
		return correos;
	}

	public void setCorreos(List<Correo> correos) {
		this.correos = correos;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", ape1=" + ape1
				+ ", ape2=" + ape2 + ", direccion=" + direccion + ", modulo="
				+ modulo + ", correos=" + correos + "]";
	}

	
	

    
}
