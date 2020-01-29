package profesor;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Prueba {

	public static void main(String[] args) {
		Prueba prueba = new Prueba();
		
		Direccion direccion = new Direccion("Federico", 52, "124124", "Madrid", null);
		Profesor profesor = new Profesor(direccion, null, "Juan","Garcia","Garcia", null);
		profesor.setDireccion(direccion);
		
		prueba.almacenaProfesor(profesor);
		
		
		Profesor profesorRecuperado = prueba.recuperaProfesor(1);
		profesorRecuperado.toString();
	}
	
	
	public void almacenaProfesor(Profesor profesor) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.save(profesor);
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
	
	public Profesor recuperaProfesor(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Profesor profesor = new Profesor();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		profesor = (Profesor) session.load(Profesor.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return profesor;
	}


}
