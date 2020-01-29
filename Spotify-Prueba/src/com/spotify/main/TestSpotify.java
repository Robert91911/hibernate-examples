package com.spotify.main;

import com.spotify.modelo.Cancion;
import com.spotify.modelo.Playlist;
import com.spotify.utilidades.Utilidades;
import com.spotify.utilidades.UtilsCancion;
import com.spotify.utilidades.UtilsPlaylist;

public class TestSpotify {
	public static void main(String[] args) {
		
		Playlist p1 = new Playlist();
		p1.setLikes(50);
		p1.setNombre("Reggeaton");

		Cancion c1 = new Cancion();
		c1.setId(6);
		c1.setTitulo("China");
		c1.setArtista("Anuel AA");
		c1.setDuracion(420);
		c1.setReproducciones(5000000);
		c1.getPlaylists().add(p1);

		UtilsCancion.almacenaCancion(c1);
		Utilidades.getSessionFactory().close();
		
//		UtilsCancion uCacion = new UtilsCancion();
//	
//		
//		Playlist p1 = new Playlist();
//		p1.setId(2);
//		
//		Cancion c1 = new Cancion("Fiebre", "Manueh", 120, 200000, null);
//		
//		p1 = UtilsPlaylist.recuperaPlaylist(p1.getId());
//		
//		
//		c1.getPlaylists().add(p1);
//		
//		uCacion.almacenaCancion(c1);
//		
//		c1.setId(6);
//		c1.setTitulo("China");
//		c1.setArtista("Anuel AA");
//		c1.setDuracion(420);
//		c1.setReproducciones(5000000);
//		c1.getPlaylists().add(p1);


		
		Utilidades.getSessionFactory().close();
	}

}
