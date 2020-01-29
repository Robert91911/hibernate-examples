package ejercicios2.ejercicio8;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * 
 * @description Clase de prueba de Hibernate. En un caso real sería un DAO: se
 *              puede hacer como ejercicio con los alumnos
 * @author Laura
 */
public class Prueba {

	/**
	 * Método para almacenar un profesor
	 * 
	 * @param prof
	 */
	public void almacenaProfesor(Profesor prof) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.save(prof);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {
			session.close();
		}

	}

	/**
	 * Método para recuperar un profesor
	 * 
	 * @param id
	 * @return
	 */
	public Profesor recuperaProfesor(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Profesor prof = new Profesor();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el profleado
		prof = (Profesor) session.load(Profesor.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return prof;
	}

	public static void main(String[] args) {
		Profesor prof = new Profesor();
		Profesor prof2=new Profesor();
		Profesor profR;
		
		prof.setNombre("Pankaj");
		prof.setApe1("garcia");
		prof.setApe2("lopez");
		
		
		prof2.setNombre("kaj");
		prof2.setApe1("garc");
		prof2.setApe2("lop");		
		
		Direccion dir2=new Direccion();
		dir2.setCalle("otra calle");
		dir2.setNumero(5);
		dir2.setPoblacion("tres cantos");
		dir2.setProvincia("Madrid");
		
		
		Direccion dir=new Direccion();
		dir.setCalle("mi calle");
		dir.setNumero(5);
		dir.setPoblacion("colmenar");
		dir.setProvincia("Madrid");
		prof.setDireccion(dir);
		prof2.setDireccion(dir2);
		
		Modulo mod=new Modulo();
		mod.setNombre("Acceso a Datos");
		mod.setCreditos(new Float(8.5));
		prof.setModulo(mod);
		prof2.setModulo(mod);
		
		List<Correo> correos=new ArrayList<Correo>();
		Correo cor1=new Correo();
		cor1.setDireccion("mail@gmail.com");
		cor1.setProveedor("gmail");
		Correo cor2=new Correo();
		cor2.setDireccion("mail@hotmail.com");
		cor2.setProveedor("microsoft");
		correos.add(cor1);
		correos.add(cor2);
		prof.setCorreos(correos);	
		
		
		List<Correo> correos2=new ArrayList<Correo>();
		Correo cor12=new Correo();
		cor12.setDireccion("mail2@gmail.com");
		cor12.setProveedor("gmail");
		Correo cor22=new Correo();
		cor22.setDireccion("mail2@hotmail.com");
		cor22.setProveedor("microsoft");
		correos2.add(cor12);
		correos2.add(cor22);
		prof2.setCorreos(correos2);
		
		
		Prueba prueba = new Prueba();
		prueba.almacenaProfesor(prof);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Profesor almacenado:" + prof.toString());
		profR = prueba.recuperaProfesor(prof.getId());
		System.out.println("Profesor recuperado:" + profR.toString());
		
		prueba.almacenaProfesor(prof2);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Profesor almacenado:" + prof2.toString());
		profR = prueba.recuperaProfesor(prof2.getId());
		System.out.println("Profesor recuperado:" + profR.toString());
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
