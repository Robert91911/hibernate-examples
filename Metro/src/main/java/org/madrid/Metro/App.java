package org.madrid.Metro;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;

import org.madrid.Metro.controlador.EstacionControlador;
import org.madrid.Metro.persistencia.Utilidades;

public class App 
{
    public static void main( String[] args )
    {
		EntityManager em = null; 
		
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();			
			EstacionControlador ec = new EstacionControlador();
			ec.ejercicio1();
			
		
			
		} catch (Exception e ) {
			if (em != null) {
				e.printStackTrace();
				System.out.println("Se va a hacer rollback de la transacción");
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		Utilidades.closeEntityManagerFactory();
    }
}