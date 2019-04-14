package es.unican.ss.LigaFutbol.domain;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="jugador")
public class Jugador {
	
	private String nombre;
	private int dorsal;
	private int goles;
	private int tarjetasAmarillas;
	private int tarjetasRojas;
	
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="goles")
	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	@XmlElement(name="tRojas")
	public int getTarjetasRojas() {
		return tarjetasRojas;
	}

	public void setTarjetasRojas(int tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}

	@XmlElement(name="tAmarillas")
	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	public void setTarjetasAmarillas(int tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	@XmlElement(name="dorsal")
	public int getDorsal() {
		return dorsal;
	}
	
}
