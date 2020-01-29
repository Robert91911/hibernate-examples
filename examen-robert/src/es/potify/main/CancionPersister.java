package es.potify.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import es.potify.modelo.Cancion;
import es.potify.utilidades.Utilidades;


public class CancionPersister {
	public static void borrarCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(cancion);
			session.getTransaction().commit();
			System.out.println("Borrando cancion: " + cancion.toString());

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	public static void actualizaCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(cancion);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	public static void almacenaCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(cancion);
			System.out.println("Cancion añadida: " + cancion.toString());
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	public static Cancion recuperaCancion(int id) {
		Session session = Utilidades.getSessionFactory().getCurrentSession();
		Cancion seg = new Cancion();
		seg = (Cancion) session.load(Cancion.class, id);
		return seg;
	}
}
