package es.unican.ss.LigaFutbolCliente.restdomain;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="equipo")
public class Equipo implements Comparable<Equipo>{

	private String nombre;
	private int puntos;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosJugados;
	private List<Jugador> jugadores;
	
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="puntos")
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@XmlElement(name="partidosGanados")
	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	@XmlElement(name="partidosPerdidos")
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	@XmlElement(name="partidosJugados")
	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	@XmlElement(name="jugador")
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public int compareTo(Equipo o) {
		return Integer.compare(o.getPuntos(), puntos);
	}
	
}
