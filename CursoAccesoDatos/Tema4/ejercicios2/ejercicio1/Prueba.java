package ejercicios2.ejercicio1;

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
		Profesor profR;
		prof.setNombre("Pankaj");
		prof.setApe1("garcia");
		prof.setApe2("lopez");
		Direccion dir=new Direccion();
		dir.setCalle("mi calle");
		dir.setNumero(5);
		dir.setPoblacion("colmenar");
		dir.setProvincia("Madrid");
		prof.setDireccion(dir);
		
		Prueba prueba = new Prueba();
		prueba.almacenaProfesor(prof);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Profesor almacenado:" + prof.toString());
		profR = prueba.recuperaProfesor(prof.getId());
		System.out.println("Profesor recuperado:" + profR.toString());
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
