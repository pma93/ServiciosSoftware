package es.unican.ss.LigaFutbolHiperenlaces.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ranking")
public class ListaJugadores {

	private List<Jugador> jugadores;
	
	public ListaJugadores() {}
			
	public ListaJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public List<Jugador> getJugadores(){
		return this.jugadores;
	}

	public void setJugadores(List<Jugador> jugadores){
		this.jugadores = jugadores;
	}
	
}
