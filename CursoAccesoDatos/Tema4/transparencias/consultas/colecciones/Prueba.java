package transparencias.consultas.colecciones;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Prueba {

	/**
	 * Navegar por una propiedad
	 */
	public void navegarPropiedad(Session session) {

		System.out.println("----------- Navegar por una propiedad -----------");
        String ape1 = (String) session.createQuery("SELECT p.nombre.ape1 FROM Profesor p WHERE id=2").uniqueResult();
        System.out.println("Ape1="+ape1);
	}

	/**
	 * Navegar por varias propiedades enlazadas
	 */
	public void navegarPropiedadesEnlazadas(Session session) {

		System.out.println("----------- Navegar por varias propiedades enlazadas-----------");
        Query query = session.createQuery("SELECT p.nombre.ape1,p.direccion.municipio.nombre FROM Profesor p WHERE p.id IN (1,2,3)");
        List<Object[]> listDatos = (List<Object[]>) query.list();
        for (Object[] datos : listDatos) {
            System.out.println("El profesor " + datos[0] + " vive en " + datos[1]);
        }
	}

	/**
	 * Función SIZE en colecciones
	 */
	public void sizeColeccion(Session session) {
		 System.out.println("----------- Función SIZE en colecciones -----------");
         Query query = session.createQuery("SELECT p.nombre.ape1,SIZE(p.correos) FROM Profesor p WHERE p.id IN (1,2,3) Group by p.nombre.ape1");
         List<Object[]> listDatos = (List<Object[]>) query.list();
         for (Object[] datos : listDatos) {
             System.out.println("El profesor " + datos[0] + " tiene  " + datos[1]+ " direcciones de correo electrónico");
         }
	}

	/**
	 * Función IS EMPTY en colecciones
	 */
	public void isEmptyColecciones(Session session) {
		  System.out.println("----------- Función IS EMPTY en colecciones -----------");
          Query query = session.createQuery("SELECT p.nombre FROM Profesor p WHERE p.correos IS EMPTY");
          List<Object> listDatos = (List<Object>) query.list();
          for (Object datos : listDatos) {
              System.out.println("El profesor " + datos + " no tiene  direcciones de correo electrónico");
          }
	}

	
	

	public static void main(String[] args) {

		Session session = Utilidades.getSessionFactory().openSession();
		Prueba prueba = new Prueba();
		prueba.navegarPropiedad(session);
		prueba.navegarPropiedadesEnlazadas(session);
		prueba.sizeColeccion(session);
		prueba.isEmptyColecciones(session);		      

		Utilidades.getSessionFactory().close();
	}

}
