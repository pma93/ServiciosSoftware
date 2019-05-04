package es.unican.ss.LigaFutbolHiperenlaces.service;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;

public class NestedEquipo {
	
	private String nombre;
	private AtomLink self;
		
	public NestedEquipo(String nombre, UriInfo uriInfo) {
		String selfURI = uriInfo.getBaseUriBuilder().path("liga").path(nombre).toString();
		self = new AtomLink("self", selfURI);
	}
	
	@XmlElement(name="link")
	public AtomLink getSelf() {
		return self;
	}
	public void setSelf(AtomLink self) {
		this.self = self;
	}	
}
