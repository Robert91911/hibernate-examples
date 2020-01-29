package seguro;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PruebaSeguro {

	public static void main(String[] args) {
		
		///////////////////Inserción de un objeto Seguro en la base de datos//////////////////////////////
		Date fecha = new Date();
		Seguro seguroInsertar = new Seguro("51236964S", "Juan", "Melenez", "Jopse", 55, 2, null, null, fecha, null);

		
		PruebaSeguro prueba = new PruebaSeguro();
		//prueba.almacenaSeguro(seguroInsertar);
		
		///////////////////Recuperación de un objeto Seguro en la base de datos//////////////////////////////
		
		Seguro seguroRecuperar = new Seguro();
		//seguroRecuperar = prueba.recuperaSeguro(3);
		seguroRecuperar.setIdSeguro(52);
		System.out.println(seguroRecuperar.toString());
		
		///////////////////Modificación de un objeto Seguro en la base de datos//////////////////////////////
		
		Seguro seguroModificar = new Seguro("51236964S", "Juan", "Melenez", "Jopse", 55, 2, 'Y', 3, fecha, "Casa");
		seguroModificar.setIdSeguro(52);
		prueba.modificarSeguro(seguroModificar);
		
		//seguroInsertar.setIdSeguro(52);
		//prueba.borraSeguro(seguroInsertar);
	}
	
	/**
	 * Método para actualizar un autor
	 * 
	 * @param aut
	 */
	public void borraSeguro(Seguro seguro) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.delete(seguro);
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
	
	private void modificarSeguro(Seguro seguro) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
				Session session = Utilidades.getSessionFactory().openSession();
				Transaction tx = null;
				try {

					// abrimos una transacción
					tx = session.beginTransaction();
					// Guardamos el objeto en la sesión
					session.update(seguro);
					// Commit de la transacción
					session.getTransaction().commit();

				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					System.out.println(e.getMessage());
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

	public void almacenaSeguro(Seguro seguro) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.save(seguro);
			// Commit de la transacci�n
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	/**
	 * Método para recuperar un autor
	 * 
	 * @param id
	 * @return
	 */
	public Seguro recuperaSeguro(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Seguro seguro = new Seguro();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		seguro = (Seguro) session.load(Seguro.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return seguro;
	}

}
