package transparencias.consultas.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Prueba {

	/**
	 * Simple consulta con HQL
	 */
	public void consultaSimple(Session session) {

		System.out.println("----------- Simple consulta con HQL -----------");
		Query query = session
				.createQuery("SELECT c FROM Ciclo c ORDER BY nombre");
		List<Ciclo> ciclos = query.list();
		for (Ciclo ciclo : ciclos) {
			System.out.println(ciclo.toString());
		}
	}

	/**
	 * Uso de AND y OR
	 */
	public void logicos(Session session) {

		System.out.println("----------- Uso de AND y OR -----------");
		Query query = session
				.createQuery("SELECT p FROM Profesor p WHERE ape1='GARCIA' AND (nombre='JUAN' OR ape2='MORENO')");
		List<Profesor> profesores = query.list();
		for (Profesor profesor : profesores) {
			System.out.println(profesor.toString());
		}
	}

	/**
	 * Funciones de agregación
	 */
	public void agregacion(Session session) {
		System.out.println("----------- Funciones de agregación -----------");
		Query query = session
				.createQuery("SELECT AVG(c.horas),SUM(c.horas),MIN(c.horas),MAX(c.horas),COUNT(*) FROM Ciclo c");
		Object[] datos = (Object[]) query.uniqueResult();
		System.out.println("AVG(c.horas)=" + datos[0]);
		System.out.println("SUM(c.horas)=" + datos[1]);
		System.out.println("MIN(c.horas)=" + datos[2]);
		System.out.println("MAX(c.horas)=" + datos[3]);
		System.out.println("COUNT(*)=" + datos[4]);
	}

	/**
	 * Concatenar Strings
	 */
	public void escalares(Session session) {
		System.out.println("----------- Concatenar Strings -----------");
		Query query = session
				.createQuery("SELECT p.nombre || ' ' || p.ape1 || ' ' || p.ape2 FROM Profesor p WHERE Id=6");
		List<Object> listDatos = (List<Object>) query.list();
		for (Object datos : listDatos) {
			System.out.println(datos);
		}
	}

	/**
	 * GROUP BY y HAVING
	 */
	public void agrupacion(Session session) {
		System.out.println("----------- GROUP BY y HAVING -----------");
		Query query = session
				.createQuery("SELECT ape1,count(ape1) FROM Profesor p GROUP BY ape1 HAVING count(ape1)>1 ORDER BY count(ape1)");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("El nombre \"" + datos[0] + "\" se repite  "
					+ datos[1] + " veces");
		}
	}

	/**
	 * GROUP BY y HAVING
	 */
	public void subconsulta(Session session) {
		System.out.println("----------- Subconsultas -----------");
		Query query = session
				.createQuery("SELECT c.nombre,c.horas FROM Ciclo c WHERE c.horas >  (SELECT  AVG(c2.horas) FROM Ciclo c2)");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out
					.println("El ciclo \""
							+ datos[0]
							+ "\" es de "
							+ datos[1]
							+ " horas, siendo mayor que la media de horas de todos los ciclos");
		}
	}

	public static void main(String[] args) {

		Session session = Utilidades.getSessionFactory().openSession();
		Prueba prueba = new Prueba();
		prueba.consultaSimple(session);
		prueba.logicos(session);
		prueba.agregacion(session);
		prueba.escalares(session);
		prueba.agrupacion(session);
		prueba.subconsulta(session);

		Utilidades.getSessionFactory().close();
	}

}
