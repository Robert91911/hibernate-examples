package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.modelo.Empleado;
import com.hibernate.utilidades.Utilidades;

public class Prueba {
	public static void main(String[] args) {
		Empleado emp = new Empleado();
		emp.setNombre("Jon");
		emp.setRol("Programmer");
		emp.setFecha(new Date());

		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		// abrimos una transacción
		session.beginTransaction();
		// Guardamos el objeto en la sesión
		session.save(emp);
		// Commit de la transacción
		session.getTransaction().commit();
		System.out.println("Employee ID=" + emp.getId());

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
