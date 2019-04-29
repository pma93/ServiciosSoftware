package es.unican.ss.LigaFutbolCliente.Runner;

import java.io.InputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import es.unican.ss.LigaFutbolCliente.jornadadomain.Gol;
import es.unican.ss.LigaFutbolCliente.jornadadomain.Jornada;
import es.unican.ss.LigaFutbolCliente.jornadadomain.Partido;
import es.unican.ss.LigaFutbolCliente.jornadadomain.Tarjeta;
import es.unican.ss.LigaFutbolCliente.restdomain.Equipo;
import es.unican.ss.LigaFutbolCliente.restdomain.Jugador;

public class Cliente {

	private static String BASE_API_LIGA = "http://localhost:8080/LigaFutbol-0.0.1-SNAPSHOT/";
	
	public static void main(String[] args) {
		
		Jornada jornada = getData();
		
		for(Partido partido : jornada.getPartidos()) {

			int resultadoLocal = partido.getEquipoLocal().getTotalGoles();
			int resultadoVisitante = partido.getEquipoVisitante().getTotalGoles();
	
			// Obtenemos de la API Rest los datos del equipo local
			Equipo equipoLocal = getEquipoRest(partido.getEquipoLocal().getNombre());
			
			// Obtenemos de la API Rest los datos del equipo visitante
			Equipo equipoVisitante = getEquipoRest(partido.getEquipoVisitante().getNombre());
			
			// Anotamos el partido jugado
			equipoLocal.setPartidosJugados(equipoLocal.getPartidosJugados()+1);
			equipoVisitante.setPartidosJugados(equipoVisitante.getPartidosJugados()+1);
			
			// Anotamos el resultado en base a victoria (3 puntos), empate (1 punto) o derrota (0 puntos)
			if(resultadoLocal > resultadoVisitante) {
				// Gana el equipo local
				equipoLocal.setPartidosGanados(equipoLocal.getPartidosGanados()+1);
				equipoLocal.setPuntos(equipoLocal.getPuntos()+3);
				equipoVisitante.setPartidosPerdidos(equipoVisitante.getPartidosPerdidos()+1);

			}else if(resultadoLocal < resultadoVisitante) {
				// Gana el equipo visitante
				equipoVisitante.setPartidosGanados(equipoVisitante.getPartidosGanados()+1);
				equipoVisitante.setPuntos(equipoVisitante.getPuntos()+3);
				equipoLocal.setPartidosPerdidos(equipoLocal.getPartidosPerdidos()+1);

			}else if(resultadoLocal == resultadoVisitante) {
				// Empate de ambos equipos
				equipoLocal.setPuntos(equipoLocal.getPuntos()+1);
				equipoVisitante.setPuntos(equipoVisitante.getPuntos()+1);
			}
			
			// Anotamos tarjetas del equipo local
			for(Tarjeta tarjeta : partido.getEquipoLocal().getTarjetas()) {
				for(Jugador jugador : equipoLocal.getJugadores()) {
					if(jugador.getDorsal() == tarjeta.getDorsal()) {
						if(tarjeta.getTipo() == "AMARILLA") {
							jugador.setTarjetasAmarillas(jugador.getTarjetasAmarillas()+1);
						}else if(tarjeta.getTipo() == "ROJA") {
							jugador.setTarjetasRojas(jugador.getTarjetasRojas()+1);
						}
					}
				}
			}
			
			// Anotamos tarjetas del equipo visitante
			for(Tarjeta tarjeta : partido.getEquipoVisitante().getTarjetas()) {
				for(Jugador jugador : equipoVisitante.getJugadores()) {
					if(jugador.getDorsal() == tarjeta.getDorsal()) {
						if(tarjeta.getTipo() == "AMARILLA") {
							jugador.setTarjetasAmarillas(jugador.getTarjetasAmarillas()+1);
						}else if(tarjeta.getTipo() == "ROJA") {
							jugador.setTarjetasRojas(jugador.getTarjetasRojas()+1);
						}
					}
				}
			}
			
			// Anotamos goles del equipo local
			for(Gol gol : partido.getEquipoLocal().getGoles()) {
				for(Jugador jugador : equipoLocal.getJugadores()) {
					if(jugador.getDorsal() == gol.getDorsal()) {
						jugador.setGoles(jugador.getGoles()+1);
					}
				}
			}
			
			// Anotamos goles del equipo local
			for(Gol gol : partido.getEquipoVisitante().getGoles()) {
				for(Jugador jugador : equipoVisitante.getJugadores()) {
					if(jugador.getDorsal() == gol.getDorsal()) {
						jugador.setGoles(jugador.getGoles()+1);
					}
				}
			}
			
			// Actualizamos resultados a través de la API REST
			putEquipoRest(equipoLocal);
			putEquipoRest(equipoVisitante);
		}
		
	}
	
	private static Jornada getData() {
		JAXBContext jaxbctx;
		Unmarshaller unmarshaller;
		Jornada jornada = null;
		// Procesamos el documento (unmarshall)
		try {
			jaxbctx = JAXBContext.newInstance(Jornada.class);
			InputStream jornadaXml = Cliente.class.getClassLoader().getResourceAsStream("jornada37.xml");
			unmarshaller = jaxbctx.createUnmarshaller();
			jornada = (Jornada) unmarshaller.unmarshal(jornadaXml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return jornada;
	}
	
	private static Equipo getEquipoRest(String nombre) {
		// Invocación API REST
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(BASE_API_LIGA);
		WebTarget resource = base.path("liga/"+nombre);
		Invocation.Builder invocationBuilder = resource.request(MediaType.APPLICATION_XML);
		invocationBuilder.accept(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		
		// Tratamiento de la respuesta
		Equipo equipo = null;
		switch(response.getStatus()) {
			case 200:
				equipo = response.readEntity(Equipo.class);
				break;
			case 404:
				System.out.printf("El equipo %s no existe%n", nombre);
				break;
			default:
				System.out.println("Se ha producido un error");
				break;
		}
		
		return equipo;
	}
	
	private static void putEquipoRest(Equipo equipo) {
		// Invocación API REST
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(BASE_API_LIGA);
		WebTarget resource = base.path("liga/"+equipo.getNombre());
		Invocation.Builder invocationBuilder = resource.request();
		Response response = invocationBuilder.put(Entity.xml(equipo));
		
		// Tratamiento de la respuesta
		switch(response.getStatus()) {
			case 200:
				System.out.printf("Equipo %s actualizado correctmente%n", equipo.getNombre());
				break;
			case 404:
				System.out.printf("El equipo %s no existe%n", equipo.getNombre());
				break;
			default:
				System.out.println("Se ha producido un error");
				break;
		}
	}

}
