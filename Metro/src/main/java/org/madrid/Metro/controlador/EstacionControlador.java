package org.madrid.Metro.controlador;

import java.util.List;

import org.madrid.Metro.modelo.Estacion;
import org.madrid.Metro.persistencia.EstacionDAO;
import org.madrid.Metro.persistencia.EstacionDAOImpl;

public class EstacionControlador {

	EstacionDAO estacionDAO;
	
		public EstacionControlador() {
			estacionDAO = new EstacionDAOImpl();
		}
		
		public void ejercicio1() {
			List<Estacion> estaciones = estacionDAO.findByNombre("IGLESIA");
			for(Estacion e: estaciones) {
				System.out.println(e.toString());
			}
		}
}
