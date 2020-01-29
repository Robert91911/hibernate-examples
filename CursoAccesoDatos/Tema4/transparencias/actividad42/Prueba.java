package transparencias.actividad42;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Prueba {

	/**
	 * Método para actualizar un autor
	 * 
	 * @param aut
	 */
	public void borraAutor(Autor aut) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.delete(aut);
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
	 * Método para actualizar un autor
	 * 
	 * @param aut
	 */
	public void creaActualizaAutor(Autor aut) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.saveOrUpdate(aut);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {
			/*
			 * Cuidado que al hacer close, los objetos pasan a estado detached,
			 * si hago close y luego fuera del try un return del objeto no
			 * tendrá acceso al valor de sus propiedades, Únicamente la clave
			 * primaria
			 */
			session.close();
		}

	}

	/**
	 * Método para recuperar un autor
	 * 
	 * @param id
	 * @return
	 */
	public Autor recuperaAutor(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Autor aut = new Autor();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		aut = (Autor) session.load(Autor.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return aut;
	}

	public static void main(String[] args) {
		Autor aut = new Autor();
		Autor autD = new Autor();
		Autor autR;
		aut.setNombre("Pankaj");
		aut.setApellidos("Garcia");
		
		aut.setFecha(new Date());
		aut.setPublicacion(true);
		autD.setNombre("Para borrar");
		autD.setApellidos("Sanchez");
		autD.setFecha(new Date());
		autD.setPublicacion(false);

		Prueba prueba = new Prueba();
		prueba.creaActualizaAutor(aut);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Autor almacenado:" + aut.getId());
		autR = prueba.recuperaAutor(aut.getId());
		System.out.println("Autor recuperado:" + autR.getApellidos());
		aut.setNombre("Pankajooo");
		// Comprobar en BD que se ha actualizado el nombre
		prueba.creaActualizaAutor(aut);

		// Vamos a borrar otro objeto
		prueba.creaActualizaAutor(autD);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Autor almacenado:" + autD.getId());
		// Comprobar que en BD no existe ningún empleado con este id
		prueba.borraAutor(autD);

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
