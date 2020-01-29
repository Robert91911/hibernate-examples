package transparencias.mapeos;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import transparencias.mapeos.Vuelo.TipoVuelo;

//import transparencias.mapeos.Vuelo.TipoVuelo;

public class Prueba {

	/**
	 * Método para actualizar un autor
	 * 
	 * @param aut
	 */
	public void creaActualizaVuelo(Vuelo vuelo) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.saveOrUpdate(vuelo);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error:" + e.getMessage());
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
	 * Método para recuperar un vuelo
	 * 
	 * @param id
	 * @return
	 */
	public Vuelo recuperaVuelo(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Vuelo vue = new Vuelo();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		vue = (Vuelo) session.load(Vuelo.class, id);
		// Commit de la transacción
		session.getTransaction().commit();
		
		return vue;
	}

	public static void main(String[] args) {
		Vuelo vue = new Vuelo();

		Vuelo vueR;

		vue.setHoraSalida(new Date());
		char[] codigo={'A','0','2','3',};
		vue.setCodigo(codigo);
		vue.setLongitud(5);
		vue.setNumero(333);
		vue.setTexto("Vuelo de prueba");
		vue.setTipo(TipoVuelo.ASIA);
		

		Prueba prueba = new Prueba();
		prueba.creaActualizaVuelo(vue);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Vuelo almacenado:" + vue.getId());
		vueR = prueba.recuperaVuelo(vue.getId());
		System.out.println("Vuelo recuperado:" + vueR.toString());

		// Cerramos la factoria de sesiones, sino el programa no finalizar�
		Utilidades.getSessionFactory().close();
	}

}
