package ejercicios2.ejercicio7;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
/**
 * Responsable de crear un objeto sesión (gestiona la conexión a BD de forma transparente
 * @author Laura
 *
 */
public class Utilidades {
	 
	    //Factoria de sesión para crear objeto sesión a partir de XML
	    private static SessionFactory sessionFactory;
	     
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Creamos una factoría de sesiones con los datos de hibernate.cfg.xml
	            Configuration configuration = new Configuration();
	            configuration.configure("/ejercicios2/ejercicio7/hibernate.cfg.xml");
	            System.out.println("Configuración de Hibernate Cargada");
	             
	            SessionFactory sessionFactory = configuration.buildSessionFactory();
	             
	            return sessionFactory;
	        }
	        catch (Throwable ex) {
	            // En un caso real se registra en un log
	            System.err.println("Falló la creación de la factoría de sesiones inicial." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    /*
	     * Método estático (Fachada) para crear la factoría de sesiones
	     */
	    public static SessionFactory getSessionFactory() {
	        if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }

}
