package spotify;
// Generated 10-dic-2019 19:26:00 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

/**
 * Cancion generated by hbm2java
 */
@Entity
@Table(name = "cancion", catalog = "espotify")
public class Cancion implements java.io.Serializable {

	private Integer id;
	private String titulo;
	private String artista;
	private int duracion;
	private Integer reproducciones;
	private Set<Playlist> playlists = new HashSet<Playlist>(0);

	public Cancion() {
	}

	public Cancion(String titulo, String artista, int duracion) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
	}

	public Cancion(String titulo, String artista, int duracion, Integer reproducciones, Set<Playlist> playlists) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
		this.reproducciones = reproducciones;
		this.playlists = playlists;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "titulo", nullable = false, length = 50)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "artista", nullable = false, length = 50)
	public String getArtista() {
		return this.artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Column(name = "duracion", nullable = false)
	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Column(name = "reproducciones")
	public Integer getReproducciones() {
		return this.reproducciones;
	}
	
	public void setReproducciones(Integer reproducciones) {
		this.reproducciones = reproducciones;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "playlist_cancion", catalog = "espotify", joinColumns = {
			@JoinColumn(name = "cancion_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "playlist_id", nullable = false, updatable = false) })
	public Set<Playlist> getPlaylists() {
		return this.playlists;
	}

	public void setPlaylists(Set<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", duracion=" + duracion
				+ ", reproducciones=" + reproducciones + ", playlists=" + playlists + "]";
	}

	
}
