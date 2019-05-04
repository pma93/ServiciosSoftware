package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Jugador;

@XmlRootElement(name="goleadores")
public class RankingRepresentation {

	private List<AtomLink> jugadoresToReturn;
	private AtomLink next;
	private AtomLink previous;

	public RankingRepresentation(List<Jugador> jugadores, UriInfo uriInfo, int indiceIni) {
		
		// indice next
		String siguienteIndice = Integer.toString(indiceIni+5);
		String nextURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", siguienteIndice).toString();
		next = new AtomLink("next",nextURI);
		
		// indice previous
		String anteriorIndice = Integer.toString(indiceIni-5);
		String previousURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", anteriorIndice).toString();
		previous = new AtomLink("previous",previousURI);
		
		jugadoresToReturn = new ArrayList<AtomLink>();

		for(int i=indiceIni; i<indiceIni+5; i++) {
			Jugador j = jugadores.get(i);
			int dorsal = j.getDorsal();
			jugadoresToReturn.add(new AtomLink("jugador",uriInfo.getBaseUriBuilder().path("liga/"+"goleadores/"+dorsal).build().toString()));
		}
	}
	
	@XmlElement
	public List<AtomLink> getJugadores() {
		return jugadoresToReturn;
	}
	
	public void setJugadores(List<AtomLink> jugadoresToReturn) {
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
