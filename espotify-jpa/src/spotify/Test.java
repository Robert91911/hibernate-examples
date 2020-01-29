package spotify;


import org.hibernate.Session;
import org.hibernate.Transaction;


public class Test {

	public static void main(String[] args) {
		
		Playlist play = new Playlist("POP", 200, null);
		
		Cancion can1 = new Cancion("Macarena", "Juan Magan", 90);
		
		can1.setReproducciones(4999);

		can1.getPlaylists().add(play);
		
		Test t = new Test();
	
		
		t.almacenaCancion(can1);
		can1.setId(6);
		//t.borrarCancion(can1);
		
		Cancion cancionRecu = t.RecuperaCancion(can1.getId());
		System.out.println(cancionRecu.toString());
		
		Utilidades.getSessionFactory().close();
		
		
	}
	
	public void almacenaCancion(Cancion cancion) {
        Session session = Utilidades.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(cancion);
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
	
	public void borrarCancion(Cancion cancion) {
        Session session = Utilidades.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(cancion);
            System.out.println("Cancion Borrada: " + cancion.toString());
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
	
	public Cancion RecuperaCancion(int id) {
		Session session = Utilidades.getSessionFactory().openSession();
		Cancion seg = new Cancion();
		session.beginTransaction();
		seg = (Cancion) session.load(Cancion.class, id);
		session.getTransaction().commit();
		return seg;
	}

}
