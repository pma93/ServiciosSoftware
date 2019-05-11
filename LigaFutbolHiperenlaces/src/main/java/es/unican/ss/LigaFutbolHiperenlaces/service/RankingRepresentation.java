package es.unican.ss.LigaFutbolHiperenlaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Jugador;

@XmlRootElement(name="ranking")
public class RankingRepresentation {

	// Resultados a mostrar por página
	private static final int RESULTS_PER_PAGE = 3;
	
	private List<NestedJugador> jugadoresToReturn;
	private AtomLink previous;
	private AtomLink next;
	private AtomLink self;
	
	public RankingRepresentation() {}

	public RankingRepresentation(List<Jugador> jugadores, UriInfo uriInfo, int indiceIni) {
		
		int numResults = jugadores.size();
		
		// Página actual comenzando por cero
		int currentPage = (int) Math.floor(indiceIni / RESULTS_PER_PAGE);
		// Índice para el comienzo de la página actual
		int currentIndex = currentPage * RESULTS_PER_PAGE;
		
		// Si el indice solicitado es válido, se calculan los resultados en base a dicha posición
		if(indiceIni >= 0 && indiceIni < numResults) {
			
			// Crear enlace anterior solo si existe
			int previousIndex = currentIndex - RESULTS_PER_PAGE;
			if(previousIndex >= 0) {
				String previousURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", previousIndex).toString();
				previous = new AtomLink("previous", previousURI);	
			}
			
			// Crear enlace siguiente solo si existe
			int nextIndex = currentIndex + RESULTS_PER_PAGE;
			if(nextIndex < numResults) {
				String nextURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", nextIndex).toString();
				next = new AtomLink("next", nextURI);
			}
			
			// Crear siempre enlace propio
			int selfIndex = currentIndex;
			String selfURI = uriInfo.getAbsolutePathBuilder().replaceQueryParam("indiceIni", selfIndex).toString();
			setSelf(new AtomLink("self", selfURI));
			
			// Crear representación de jugadores
			int resultsLeft = (numResults - indiceIni);
			int resultsToShow = resultsLeft < RESULTS_PER_PAGE ? resultsLeft : RESULTS_PER_PAGE; 
			jugadoresToReturn = new ArrayList<NestedJugador>();
			for(int i = indiceIni; i < indiceIni + resultsToShow; i++) {
				Jugador jugador = jugadores.get(i);
				jugadoresToReturn.add(new NestedJugador(jugador.getNombre(), jugador.getNombreEquipo(), jugador.getDorsal(), uriInfo));
			}
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
