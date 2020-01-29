package es.potify.main;

import java.util.Collection;

import es.potify.modelo.Cancion;
import es.potify.modelo.Cancion.Valoracion;
import es.potify.modelo.Playlist;
import es.potify.utilidades.Utilidades;
//import es.potify.main.CancionPersister.Valoracion;

public class Espotify {

	public static void main(String[] args) {
		Utilidades.buildSessionFactory();
		
		try {
			Utilidades.openSessionAndBindToThread();
		
          /*Ejercicio 5*/
//			Cancion c1;
//			c1 = CancionPersister.recuperaCancion(3);
//			System.out.println("Cancion recuperada: "+c1.toString());
          
          
			
			
          /*Ejercicio 6*/
//			Cancion c2 = new Cancion("Fiebre", "Juan Magan", 130);
//			c2.setPuntos(Valoracion.GOOD);
//			CancionPersister.almacenaCancion(c2);
			
          /*Ejercicio 8*/
//          Playlist play1 = new Playlist("ParaLikes", 1000000, null);
//          System.out.println(play1.getGanancias());
			
		  /*Ejercicio 9*/
			
			Cancion c1 = new Cancion("Fiebre", "Juan Magan", 130);
			Cancion c2 = new Cancion("Amarillo", "Juan Magan", 230);
			
			Playlist play1 = new Playlist();
			play1.setNombre("Pop");
			play1.setLikes(2000000);
			
			play1.getCancions().add(c1);
			play1.getCancions().add(c2);
			
			PlaylistPersister.almacenaPlaylist(play1);
			
		  /*Ejercicio 10*/
//			Cancion c1;
//			c1 = CancionPersister.recuperaCancion(1);
//			System.out.println(c1.toString());
//			c1.setValoracion(4);
//			CancionPersister.actualizaCancion(c1);
			
			/*Ejercicio 11*/
//			Playlist play1 = new Playlist();
//			play1.setId(4);
//			play1 = PlaylistPersister.recuperaPlaylist(play1.getId());
//			play1.getCancions().remove(play1.getCancions());
//			PlaylistPersister.actualizaPlaylist(play1);
			
			/*Ejercicio 12*/
//			Cancion c1 = new Cancion();
//			c1.setId(1);
//			CancionPersister.recuperaCancion(c1.getId());
//			CancionPersister.borrarCancion(c1);
			
			
			
          
		} finally {
			Utilidades.closeSessionAndUnbindFromThread();
		}
		
		Utilidades.closeSessionFactory();

	}

}
