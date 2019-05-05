package es.unican.ss.LigaFutbolHiperenlaces.service;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="equipo")
public class NestedEquipo {

	private String nombre;
	private AtomLink self;

	public NestedEquipo() {}

	public NestedEquipo(String nombreEquipo, UriInfo uriInfo) {
		this.setNombre(nombreEquipo);
		String selfURI = uriInfo.getAbsolutePathBuilder().path(nombreEquipo).toString();
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
