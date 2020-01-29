package org.madrid.Metro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.madrid.Metro.modelo.*;

public class EstacionDAOImpl extends GenericDAOImplJpa<Estacion,Integer> implements EstacionDAO {
	
	public List<Estacion> findByNombre(String nombre) {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Estacion> q = em.createQuery(
				"select e "
				+ "from Estacion e "
				+ "where e.nombre = :nombre", Estacion.class)
		.setParameter("nombre", nombre);
		
		return q.getResultList();
		
	}
	
}

