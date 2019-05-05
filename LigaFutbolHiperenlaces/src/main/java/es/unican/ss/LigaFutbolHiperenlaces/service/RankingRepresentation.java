package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Jugador;

public class RankingRepresentation {

	private List<NestedJugador> jugadoresToReturn;
	private AtomLink next;
	private AtomLink previous;

	public RankingRepresentation(List<Jugador> jugadores, UriInfo uriInfo, int indiceIni) {
		
		// indice next
		String siguienteIndice = Integer.toString(indiceIni+5);
		String nextURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", siguienteIndice).toString();
		next = new AtomLink("next",nextURI);
			
		jugadoresToReturn = new ArrayList<NestedJugador>();

		for(int i=indiceIni; i<Math.min(indiceIni+5, jugadores.size()); i++) {
			Jugador j = jugadores.get(i);
			int dorsal = j.getDorsal();
			NestedJugador nestedJug = new NestedJugador(Integer.toString(dorsal), uriInfo);
			jugadoresToReturn.add(nestedJug);
		}
	}
	
	@XmlElement
	public List<NestedJugador> getJugadores() {
		return jugadoresToReturn;
	}
	
	public void setJugadores(List<NestedJugador> jugadoresToReturn) {
		this.jugadoresToReturn = jugadoresToReturn;
	}
	
	@XmlElement
	public AtomLink getNext() {
		return next;
	}
	
	public void setNext(AtomLink next) {
		this.next = next;
	}
	
	@XmlElement
	public AtomLink getPrevious() {
		return previous;
	}
	
	public void setPrevious(AtomLink previous) {
		this.previous = previous;
	}
}
