package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Equipo;
import es.unican.ss.LigaFutbolHiperenlaces.service.AtomLink;

@XmlRootElement(name="clasificacion")
public class ClasificacionRepresentation {

	private NestedEquipo equipoNested;
	private AtomLink previous;
	private AtomLink next;
	private AtomLink self;

	public ClasificacionRepresentation() {}
	
	public ClasificacionRepresentation(List<Equipo> equipos, UriInfo uriInfo, int indiceIni) {

		if(indiceIni >= 0 && indiceIni <= equipos.size()-1) {
			
			// Indices anterior y siguiente
			int previousIndex = indiceIni - 1;
			int nextIndex = indiceIni+1;
			
			// Crear enlace anterior solo si existe
			if(previousIndex >= 0) {
				String previousURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", previousIndex).toString();
				previous = new AtomLink("previous", previousURI);	
			}
			
			// Crear enlace siguiente solo si existe
			if(nextIndex <= equipos.size()-1) {
				String nextURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", nextIndex).toString();
				next = new AtomLink("next", nextURI);
			}
			
			// Crear siempre enlace propio 
			String selfURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", indiceIni).toString();
			self = new AtomLink("self", selfURI);

			// Crear representación equipo
			Equipo eq = equipos.get(indiceIni);
			equipoNested = new NestedEquipo(eq.getNombre(), uriInfo);
		}

	}

	@XmlElement(name="link")
	public AtomLink getPrevious() {
		return previous;
	}

	public void setPrevious(AtomLink previous) {
		this.previous = previous;
	}

	@XmlElement(name="link")
	public AtomLink getNext() {
		return next;
	}

	public void setNext(AtomLink next) {
		this.next = next;
	}

	@XmlElement(name="link")
	public AtomLink getSelf() {
		return self;
	}

	public void setSelf(AtomLink self) {
		this.self = self;
	}
	
	@XmlElement(name="equipo")
	public NestedEquipo getEquipo() {
		return equipoNested;
	}

	public void setEquipo(NestedEquipo equipoNested) {
		this.equipoNested = equipoNested;
	}
}
