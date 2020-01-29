package seguro;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class PruebaSeguro {

	public static void main(String[] args) {
		Date fecha = new Date();
		Seguros seguros = new Seguros(1, "51256964S", "Juan", "Melenez", "Jopse", 55, 2, fecha);

		
		PruebaSeguro prueba = new PruebaSeguro();
		prueba.almacenaSeguro(seguros);

	}
	
	public void almacenaSeguro(Seguros seguro) {
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

}
