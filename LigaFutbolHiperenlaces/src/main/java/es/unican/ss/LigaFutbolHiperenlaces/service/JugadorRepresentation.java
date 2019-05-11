package es.unican.ss.LigaFutbolHiperenlaces.service;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Jugador;

@XmlRootElement(name="jugador")
@XmlType(propOrder={"nombre", "dorsal", "goles", "tarjetasAmarillas", "tarjetasRojas", "nombreEquipo", "self"})
public class JugadorRepresentation {

	private String nombre;
	private int dorsal;
	private int goles;
	private int tarjetasAmarillas;
	private int tarjetasRojas;
	private String nombreEquipo;
	private AtomLink self;
	
	public JugadorRepresentation() {}

	public JugadorRepresentation(Jugador jugador, UriInfo uriInfo) {
		this.setNombre(jugador.getNombre());
		this.setDorsal(jugador.getDorsal());
		this.setGoles(jugador.getGoles());
		this.setTarjetasAmarillas(jugador.getTarjetasAmarillas());
		this.setTarjetasRojas(jugador.getTarjetasRojas());
		this.setNombreEquipo(jugador.getNombreEquipo());
		
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

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	public void setTarjetasAmarillas(int tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	public int getTarjetasRojas() {
		return tarjetasRojas;
	}

	public void setTarjetasRojas(int tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
}
