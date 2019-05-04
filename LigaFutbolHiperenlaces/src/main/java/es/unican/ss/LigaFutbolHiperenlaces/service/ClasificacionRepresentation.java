package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Equipo;

@XmlRootElement(name="liga")
public class ClasificacionRepresentation {

	private List<NestedEquipo> equiposToReturn;
	private AtomLink previous;
	private AtomLink next;

	public ClasificacionRepresentation(List<Equipo> equipos, UriInfo uriInfo, int indiceIni) {

		// indice next
		String siguienteIndice = Integer.toString(indiceIni+5);
		String nextURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", siguienteIndice).toString();
		next = new AtomLink("next",nextURI);
		
		// indice previous
		String anteriorIndice = Integer.toString(indiceIni-5);
		String previousURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", anteriorIndice).toString();
		previous = new AtomLink("previous",previousURI);
		
		equiposToReturn = new ArrayList<NestedEquipo>();

		for(int i=indiceIni; i<indiceIni+5; i++) {
			Equipo eq = equipos.get(i);
			String nombreEq = eq.getNombre();
			NestedEquipo nestedEq = new NestedEquipo(nombreEq, uriInfo);
			equiposToReturn.add(nestedEq);
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
	public List<NestedEquipo> getEquipos() {
		return equiposToReturn;
	}

	public void setEquipos(List<NestedEquipo> equiposToReturn) {
		this.equiposToReturn = equiposToReturn;
	}
}
