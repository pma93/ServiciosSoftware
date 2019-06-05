package es.unican.ss.LigaFutbolHiperenlaces.service;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;

import es.unican.ss.LigaFutbolHiperenlaces.service.AtomLink;

public class NestedJugador {
	
	private int dorsal;
	private String nombre;
	private AtomLink self;
	
	public NestedJugador() {}

	public NestedJugador(String nombre, String nombreEquipo, int dorsal, UriInfo uriInfo) {
		this.setDorsal(dorsal);
		this.setNombre(nombre);
		String selfURI = uriInfo.getBaseUriBuilder().path("liga/"+nombreEquipo+"/"+dorsal).toString();
		setSelf(new AtomLink("self", selfURI));
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name="link")
	public AtomLink getSelf() {
		return self;
	}

	public void setSelf(AtomLink self) {
		this.self = self;
	}

	@XmlElement
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
}
