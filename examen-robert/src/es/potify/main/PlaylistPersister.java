package es.potify.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import es.potify.modelo.Playlist;
import es.potify.utilidades.Utilidades;

public class PlaylistPersister {
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
		}
	}

	public static Playlist recuperaPlaylist(int id) {
		Session session = Utilidades.getSessionFactory().openSession();
		Playlist playlist = new Playlist();
		playlist = (Playlist) session.load(Playlist.class, id);
		return playlist;
	}
}
