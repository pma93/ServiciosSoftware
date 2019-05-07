package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Jugador;

@XmlRootElement(name="ranking")
public class RankingRepresentation {

	private List<NestedJugador> jugadoresToReturn;
	private AtomLink previous;
	private AtomLink next;
	private AtomLink self;
	
	public RankingRepresentation() {}

	public RankingRepresentation(List<Jugador> jugadores, UriInfo uriInfo, int indiceIni) {
		
		jugadoresToReturn = new ArrayList<NestedJugador>();
		
		for(int i=indiceIni; i<indiceIni+3; i++) {
			
			// Indices anterior y siguiente
			int previousIndex = indiceIni - 3;
			int nextIndex = indiceIni+3;
			
			// Crear enlace anterior solo si existe
			if(previousIndex >= 0) {
				String previousURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", previousIndex).toString();
				previous = new AtomLink("previous", previousURI);	
			}
			
			// Crear enlace siguiente solo si existe
			if(nextIndex <= jugadores.size()-1) {
				String nextURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", nextIndex).toString();
				next = new AtomLink("next", nextURI);
			}
			
			// Crear siempre enlace propio 
			String selfURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", indiceIni).toString();
			setSelf(new AtomLink("self", selfURI));

			// Crear representación jugador
			Jugador jugador = jugadores.get(i);
			String nombrejug = jugador.getNombre();
			int dorsalJug = jugador.getDorsal();
			jugadoresToReturn.add(new NestedJugador(nombrejug, dorsalJug, uriInfo));
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

	@XmlElement(name="jugador")
	public List<NestedJugador> getJugadoresToReturn() {
		return jugadoresToReturn;
	}

	public void setJugadoresToReturn(List<NestedJugador> jugadoresToReturn) {
		this.jugadoresToReturn = jugadoresToReturn;
	}
}
