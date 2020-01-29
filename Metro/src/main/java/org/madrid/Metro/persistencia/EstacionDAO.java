package org.madrid.Metro.persistencia;

import java.util.List;

import org.madrid.Metro.modelo.Estacion;

public interface EstacionDAO extends GenericDAO<Estacion,Integer> {

	public List<Estacion> findByNombre(String nombre);
}
