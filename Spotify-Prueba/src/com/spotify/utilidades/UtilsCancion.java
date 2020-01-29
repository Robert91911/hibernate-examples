package com.spotify.utilidades;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.spotify.modelo.Cancion;


public class UtilsCancion {
	public static void borrarCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().openSession();
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
		} finally {
			session.close();
		}
	}

	public static void actualizaCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(cancion);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void almacenaCancion(Cancion cancion) {
		Session session = Utilidades.getSessionFactory().openSession();
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
		} finally {
			session.close();
		}
	}

	public static Cancion recuperaCancion(int id) {
		Session session = Utilidades.getSessionFactory().openSession();
		Cancion seg = new Cancion();
		seg = (Cancion) session.load(Cancion.class, id);
		session.close();
		return seg;
	}
}