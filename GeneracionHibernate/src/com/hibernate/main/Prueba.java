package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.modelo.Autor;
import com.hibernate.utilidades.Utilidades;

public class Prueba {
	public static void main(String[] args) {
		Autor autor = new Autor();
		autor.setNombre("jose");
		autor.setApellidos("RodriguezLopez");
		autor.setFecha(new Date());
		autor.setPublicacion(true);

		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		// abrimos una transacción
		session.beginTransaction();
		// Guardamos el objeto en la sesión
		session.save(autor);
		// Commit de la transacción
		session.getTransaction().commit();
		System.out.println("Autor=" + autor.getId());

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
