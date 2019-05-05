package es.unican.ss.LigaFutbolHiperenlaces.service;

import javax.ws.rs.core.UriInfo;

import es.unican.ss.LigaFutbolHiperenlaces.service.AtomLink;

public class NestedJugador {
	
	private AtomLink self;

	public NestedJugador(String dorsal, UriInfo uriInfo) {
		String selfURI = uriInfo.getAbsolutePathBuilder().path(dorsal).toString();
		self = new AtomLink("self", selfURI);
	}

	public AtomLink getSelf() {
		return self;
	}

	public void setSelf(AtomLink self) {
		this.self = self;
	}
}
