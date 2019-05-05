package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Equipo;
import es.unican.ss.LigaFutbolHiperenlaces.service.AtomLink;

public class ClasificacionRepresentation {

	private List<AtomLink> equiposToReturn;
	private AtomLink previous;
	private AtomLink next;

	public ClasificacionRepresentation(List<Equipo> equipos, UriInfo uriInfo, int indiceIni) {

		// indice next
		String siguienteIndice = Integer.toString(indiceIni+5);
		String nextURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", siguienteIndice).toString();
		next = new AtomLink("next",nextURI);
		
		AtomLink atomLink = null;
		URI uri = null;
		equiposToReturn = new ArrayList<AtomLink>();
		
		for(int i=indiceIni; i<Math.min(indiceIni+5, equipos.size()); i++) {
			Equipo eq = equipos.get(i);
			String nombreEq = eq.getNombre();
			uri = uriInfo.getAbsolutePathBuilder().path(nombreEq).build();
			atomLink = new AtomLink("equipo", uri.toString());
			equiposToReturn.add(atomLink);
		}
	}

	@XmlElement
	public AtomLink getPrevious() {
		return previous;
	}

	public void setPrevious(AtomLink previous) {
		this.previous = previous;
	}

	@XmlElement
	public AtomLink getNext() {
		return next;
	}

	public void setNext(AtomLink next) {
		this.next = next;
	}

	@XmlElement
	public List<AtomLink> getEquipos() {
		return equiposToReturn;
	}

	public void setEquipos(List<AtomLink> equiposToReturn) {
		this.equiposToReturn = equiposToReturn;
	}
}
