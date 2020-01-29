package com.spotify.utilidades;


import org.hibernate.Session;
import org.hibernate.Transaction;
import com.spotify.modelo.Playlist;


public class UtilsPlaylist {
	public static void borrarPlaylist(Playlist playlist) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(playlist);
			session.getTransaction().commit();
			System.out.println("Borrando Playlist: " + playlist.toString());

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void actualizaPlaylist(Playlist playlist) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(playlist);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void almacenaPlaylist(Playlist playlist) {
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(playlist);
			System.out.println("Playlist añadida: " + playlist.toString());
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static Playlist recuperaPlaylist(int id) {
		Session session = Utilidades.getSessionFactory().openSession();
		Playlist playlist = new Playlist();
		playlist = (Playlist) session.load(Playlist.class, id);
		session.close();
		return playlist;
	}
}