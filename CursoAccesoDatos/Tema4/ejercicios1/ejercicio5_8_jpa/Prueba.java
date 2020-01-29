package ejercicios1.ejercicio5_8_jpa;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ejercicios1.ejercicio5_8_jpa.Seguro.TipoSeguro;
import ejercicios1.ejercicio5_8_jpa.Seguro.TipoSexo;

/**
 * 
 * @description Clase que proprociona métodos para borrar, insertar, actualizar
 *              y recuperar de BD seguros
 * @author Laura
 */
public class Prueba {

	/**
	 * Método para actualizar un seguro
	 * 
	 * @param seg
	 */
	public void borraSeguro(Seguro seg) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.delete(seg);
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
	 * Método para actualizar un seguro
	 * 
	 * @param seg
	 */
	public void actualizaSeguro(Seguro seg) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.update(seg);
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
	 * Método para almacenar un seguro
	 * 
	 * @param seg
	 */
	public void almacenaSeguro(Seguro seg) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.save(seg);
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
	 * Método para recuperar un seguro
	 * 
	 * @param id
	 * @return
	 */
	public Seguro RecuperaSeguro(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Seguro seg = new Seguro();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el seguro
		seg = (Seguro) session.load(Seguro.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return seg;
	}

	public static void main(String[] args) {
		Seguro seg = new Seguro();
		Seguro segR;
		seg.setNombre("Pankaj");
		seg.setApe1("Garcia");
		seg.setApe2("Lopez");
		seg.setNif("7656984549N");
		seg.setFechaCreacion(new Date());
		seg.setNumHijos(2);
		seg.setSexo(TipoSexo.HOMBRE);
		seg.setEdad(29);
		seg.setTipo(TipoSeguro.VIAJE);
		seg.setCasado(true);
		seg.setFechaNacimiento(new Date());
		seg.setHoraContacto(new Date());
		seg.setComentarios("sdafsdfsdfsdfasdf");
		char[] claves = { 'A', '0', '2', '3', };
		seg.setClaves(claves);

		Prueba prueba = new Prueba();
		prueba.almacenaSeguro(seg);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Seguro almacenado:" + seg.toString());
		segR = prueba.RecuperaSeguro(seg.getIdSeguro());
		// Fijarse como la formula de esMayorEdad sólo se aplica al recuperar,
		// modo lectura
		System.out.println("Seguro recuperado:" + segR.toString());
		seg.setNombre("Pankajooo");
		// Comprobar en BD que se ha actualizado el nombre
		prueba.actualizaSeguro(seg);

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
