package es.unican.ss.LigaFutbolCliente.restdomain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.LigaFutbolCliente.restdomain.NestedJugador;

@XmlRootElement(name="jugadores")
public class ListaJugadores {

	private List<NestedJugador> jugadores;
	
	public ListaJugadores() {}
			
	public ListaJugadores(List<NestedJugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	@XmlElement(name="jugador")
	public List<NestedJugador> getJugadores(){
		return this.jugadores;
	}

	public void setJugadores(List<NestedJugador> jugadores){
		this.jugadores = jugadores;
	}
	
}
