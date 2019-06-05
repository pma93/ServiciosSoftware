package es.unican.ss.LigaFutbolCliente.jornadadomain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Equipo {
	
	private String nombre;
	private int totalGoles;
	private List<Gol> goles;
	private List<Tarjeta> tarjetas;
	
	public Equipo() {
		this.setGoles(new ArrayList<Gol>());
		this.setTarjetas(new ArrayList<Tarjeta>());
	}
	
	@XmlAttribute(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlAttribute(name="totalGoles")
	public int getTotalGoles() {
		return totalGoles;
	}
	public void setTotalGoles(int totalGoles) {
		this.totalGoles = totalGoles;
	}

	public List<Gol> getGoles() {
		return goles;
	}

	@XmlElement(name="gol")
	public void setGoles(List<Gol> goles) {
		this.goles = goles;
	}

	@XmlElement(name="tarjeta")
	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

}
