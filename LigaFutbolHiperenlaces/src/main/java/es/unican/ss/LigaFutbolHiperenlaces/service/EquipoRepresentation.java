package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.util.ArrayList;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Equipo;
import es.unican.ss.LigaFutbolHiperenlaces.domain.Jugador;
import es.unican.ss.LigaFutbolHiperenlaces.domain.ListaJugadores;

@XmlRootElement(name="equipo")
public class EquipoRepresentation {

	private String nombre;
	private int puntos;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosJugados;
	private ListaJugadores jugadoresNested;
	private AtomLink self;
	
	public EquipoRepresentation() {}

	public EquipoRepresentation(Equipo equipo, UriInfo uriInfo) {
		
		this.setNombre(equipo.getNombre());
		this.setPuntos(equipo.getPuntos());
		this.setPartidosGanados(equipo.getPartidosGanados());
		this.setPartidosPerdidos(equipo.getPartidosPerdidos());
		this.setPartidosJugados(equipo.getPartidosJugados());
		this.jugadoresNested = new ListaJugadores(new ArrayList<NestedJugador>());
		
		for(Jugador jugador : equipo.getJugadores()) {
			jugadoresNested.getJugadores().add(new NestedJugador(jugador.getNombre(), jugador.getDorsal(), uriInfo));
		}
		
		// Crear enlace propio 
		String selfURI = uriInfo.getAbsolutePathBuilder().toString();
		setSelf(new AtomLink("self", selfURI));

	}

	@XmlElement(name="link")
	public AtomLink getSelf() {
		return self;
	}

	public void setSelf(AtomLink self) {
		this.self = self;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	@XmlElement(name="jugadores")
	public ListaJugadores getJugadoresNested() {
		return jugadoresNested;
	}

	public void setJugadoresNested(ListaJugadores jugadoresNested) {
		this.jugadoresNested = jugadoresNested;
	}
	
}
