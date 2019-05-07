package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Equipo;
import es.unican.ss.LigaFutbolHiperenlaces.service.AtomLink;

@XmlRootElement(name="clasificacion")
public class ClasificacionRepresentation {

	private List<AtomLink> equiposToReturn;
	private AtomLink self;

	public ClasificacionRepresentation() {}
	
	public ClasificacionRepresentation(List<Equipo> equipos, UriInfo uriInfo) {

		AtomLink atomLink = null;
		equiposToReturn = new ArrayList<AtomLink>();
		
		for(Equipo eq: equipos) {
			URI uri = uriInfo.getAbsolutePathBuilder().path(eq.getNombre()).build();
			atomLink = new AtomLink("self", uri.toString());
			equiposToReturn.add(atomLink);
		}
	}

	@XmlElement(name="link")
	public AtomLink getSelf() {
		return self;
	}

	public void setSelf(AtomLink self) {
		this.self = self;
	}
	
	@XmlElement(name="equipo")
	public List<AtomLink> getEquiposToReturn() {
		return equiposToReturn;
	}

	public void setEquiposToReturn(List<AtomLink> equiposToReturn) {
		this.equiposToReturn = equiposToReturn;
	}
}
