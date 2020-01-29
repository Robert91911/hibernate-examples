package transparencias.sesiones;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * 
 * Clase de prueba de Hibernate. En un caso real sería un DAO
 * 
 */
public class Prueba {

	/**
	 * Método para borrar un empleado
	 * 
	 * @param emp
	 */
	public void borraEmpleado(Empleado emp) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.delete(emp);
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
	 * Método para actualizar un empleado
	 * 
	 * @param emp
	 */
	public void actualizaEmpleado(Empleado emp) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.update(emp);
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
	 * Método para almacenar un empleado
	 * 
	 * @param emp
	 */
	public void almacenaEmpleado(Empleado emp) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.save(emp);
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
	 * Método para recuperar un empleado
	 * 
	 * @param id
	 * @return
	 */
	public Empleado RecuperaEmpleado(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Empleado emp = new Empleado();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		emp = (Empleado) session.load(Empleado.class, id);
		System.out.println("Empleado tras load en Recupera empleado:"
				+ emp.toString());
		// Commit de la transacción
		session.getTransaction().commit();
		
		return emp;
	}

	/**
	 * Método para comprender ámbito del objeto session y estados de los objetos
	 * 
	 * @param id
	 * @return
	 */
	public void sesionEstados(int id) {
		System.out.println("\n ----- sesión y estados -----\n");
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			Empleado emp = new Empleado(); // Este objeto está en estado
											// transient
			System.out
					.println("Empleado instanciado (transient) en sesionEstados:"
							+ emp.toString());
			// No marco la transacción para entender los estados y la sesión
			// pero siempre debo marcarla
			// Recuperamos el empleado
			emp = (Empleado) session.load(Empleado.class, id);
			System.out
					.println("Empleado tras load (persistent) en sesionEstados:"
							+ emp.toString());
			emp.setNombre("cambio de nombre");
			session.saveOrUpdate(emp);
			
			session.getTransaction().commit();
			System.out
			.println("Empleado tras saveOrUpdate (persistent) en sesionEstados\ncomprobar que el cambio es efectivo en BD:"
					+ emp.toString());

			session.close(); //Se debe cerrar en finally es para ilustrar detached
			emp.setNombre("session cerrada"); //Aunque cierre la sesión sigo teniendo acceso a mi objeto
			emp.setRol("Nuevo rol");//Puedo modificarlo como quiera
			System.out
			.println("Empleado tras cerrar sesión (detached) en sesionEstados\n Estos cambios no son efectivo en BD:"
					+ emp.toString());
			//Si quiero que sea efectivo tenfo que volver a conectarlo con la sesi�n
			/*
			session = Utilidades.getSessionFactory().openSession();			 
			tx = session.beginTransaction();
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
			System.out
			.println("Empleado tras saveOrUpdate (persistent de nuevo) en sesionEstados\ncomprobar que el cambio es efectivo en BD:"
					+ emp.toString());
			*/
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {
			//session.close();
		}

	}

	public static void main(String[] args) {
		Empleado emp = new Empleado();
		Empleado empD = new Empleado();
		Empleado empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		empD.setNombre("Para borrar");
		empD.setRol("Programador");
		empD.setFecha(new Date());

		Prueba prueba = new Prueba();
		prueba.almacenaEmpleado(emp);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp.toString());
		empR = prueba.RecuperaEmpleado(emp.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
		emp.setNombre("Pankajooo");
		// Comprobar en BD que se ha actualizado el nombre
		prueba.actualizaEmpleado(emp);

		// Vamos a borrar otro objeto
		prueba.almacenaEmpleado(empD);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out
				.println("Empleado almacenado para borrar:" + empD.toString());
		// Comprobar que en BD no existe ningún empleado con este id
		prueba.borraEmpleado(empD);
		// Después de borrar el empleado, sigo manteniendo el objeto.
		System.out.println("Empleado borrado:" + empD.toString());
		// Probamos los estados de un objeto
		prueba.sesionEstados(emp.getId());
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
