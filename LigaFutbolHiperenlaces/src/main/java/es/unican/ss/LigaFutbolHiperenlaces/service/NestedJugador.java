package es.unican.ss.LigaFutbolHiperenlaces.service;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;

import es.unican.ss.LigaFutbolHiperenlaces.service.AtomLink;

public class NestedJugador {
	
	private String nombre;
	private AtomLink self;
	
	public NestedJugador() {}

	public NestedJugador(String nombre, int dorsal, UriInfo uriInfo) {
		this.setNombre(nombre);
		String selfURI = uriInfo.getAbsolutePathBuilder().path(Integer.toString(dorsal)).toString();
		self = new AtomLink("self", selfURI);
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
}
