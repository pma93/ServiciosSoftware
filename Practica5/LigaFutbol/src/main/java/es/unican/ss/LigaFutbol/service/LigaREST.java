package es.unican.ss.LigaFutbol.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import es.unican.ss.LigaFutbol.dao.ILigaDAO;
import es.unican.ss.LigaFutbol.dao.LigaDAOImp;
import es.unican.ss.LigaFutbol.domain.Equipo;
import es.unican.ss.LigaFutbol.domain.Jugador;
import es.unican.ss.LigaFutbol.domain.ListaEquipos;
import es.unican.ss.LigaFutbol.domain.ListaJugadores;

@Path("/liga")
public class LigaREST {

	private ILigaDAO ligaDAO;

	public LigaREST() {
		ligaDAO = new LigaDAOImp();
	}

	/**
	 * Consultar clasificacion Liga (GET)
	 */
	@GET
	@Produces({"application/xml","application/json"})
	public Response getClasificacionLiga() {
		
		Response.ResponseBuilder builder;
		
		List<Equipo> listaEquipos = ligaDAO.getEquipos();
		if(!listaEquipos.isEmpty()) {
			Collections.sort(listaEquipos);
			builder = Response.ok(new ListaEquipos(listaEquipos));
			return builder.build();	
		}
		builder = Response.status(Response.Status.NOT_FOUND);
		return builder.build();
	}

	/**
	 * Consultar datos de un equipo (GET)
	 */
	@GET
	@Path("/{nombreEquipo}")
	@Produces({"application/xml","application/json"})
	public Response getDatosEquipo(@PathParam("nombreEquipo") String equipo) {

		Response.ResponseBuilder builder;
		Equipo eq = ligaDAO.getEquipo(equipo);

		if(eq != null) {
			builder = Response.ok(eq);
			return builder.build();
		}

		builder = Response.status(Response.Status.NOT_FOUND);
		return builder.build();
	}

	/**
	 * Actualizar datos de equipo con los 
	 * resultados de la jornada (PUT)
	 */
	@PUT
	@Path("/{nombreEquipo}")
	@Consumes("application/xml")
	@Produces({"application/xml","application/json"})
	public Response updateEquipo(@PathParam("nombreEquipo") String nombre, Equipo equipo) {

		Response.ResponseBuilder builder;
		Equipo eq = ligaDAO.actualizaEquipo(equipo);

		if(eq != null) {
			builder = Response.ok(eq);
			return builder.build();	
		}

		builder = Response.status(Response.Status.NOT_FOUND);
		return builder.build();	
	}

	/**
	 * Anhadir un jugador a un equipo (POST)
	 */
	@POST
	@Path("/{nombreEquipo}")
	@Consumes("application/xml")
	@Produces({"application/xml","application/json"})
	public Response addJugadorEquipo(@PathParam("nombreEquipo") String equipo, 
			@Context UriInfo uriInfo, Jugador jugador) {
		
		Response.ResponseBuilder builder;
		Equipo eq = ligaDAO.getEquipo(equipo);
		Jugador jug = ligaDAO.getJugador(equipo, jugador.getDorsal());
		
		// Si existe ya, se produce conflicto
		if(jug != null) {
			builder = Response.status(Response.Status.CONFLICT);
			return builder.build();
		}
		
		// Si no existe ya, se añade
		if(eq.getJugadores().add(jugador)) {
			try {
				ligaDAO.actualizaEquipo(eq);
				String location = uriInfo.getAbsolutePathBuilder().toString() + "/" + jugador.getDorsal();
				builder = Response.created(new URI(location));
			} catch (URISyntaxException e) {
				builder = Response.serverError();
			}
		}else {
			builder = Response.serverError();
		}
		
		return builder.build();
	}
	
	/**
	 * Consultar datos de un jugador (GET)
	 */
	@GET
	@Path("/{nombreEquipo}/{dorsal}")
	@Produces({"application/xml","application/json"})
	public Response getDatosJugador(@PathParam("nombreEquipo") String equipo,
			@PathParam("dorsal") int dorsal) {

		Response.ResponseBuilder builder;
		Jugador jugador = ligaDAO.getJugador(equipo, dorsal);
		
		if(jugador != null) {
			builder = Response.ok(jugador);
			return builder.build();
		}

		builder = Response.status(Response.Status.NOT_FOUND);
		return builder.build();
	}

	/**
	 * Actualizar jugador con los goles y
	 * tarjetas de la jornada (PUT)
	 */
	@PUT
	@Path("/{nombreEquipo}/{dorsal}")
	@Consumes("application/xml")
	@Produces({"application/xml","application/json"})
	public Response updateJugador(@PathParam("nombreEquipo") String equipo,
			@PathParam("dorsal") int dorsal, Jugador jugador) {
		
		Response.ResponseBuilder builder;
		Jugador jug = ligaDAO.getJugador(equipo, dorsal);
		
		if(ligaDAO.actualizaJugador(equipo, jugador) != null) {
			builder = Response.ok(jug);
			return builder.build();
		}
		
		builder = Response.status(Response.Status.NOT_FOUND);
		return builder.build();
	}
	
	/**
	 * Eliminar un jugador de un equipo (DELETE)
	 */
	@DELETE
	@Path("/{nombreEquipo}/{dorsal}")
	@Produces({"application/xml","application/json"})
	public Response deleteJugadorEquipo(@PathParam("nombreEquipo") String equipo,
			@PathParam("dorsal") int dorsal) {

		Response.ResponseBuilder builder;
		Equipo eq = ligaDAO.getEquipo(equipo);
		Jugador jug = ligaDAO.getJugador(equipo, dorsal);
		
		if(eq.getJugadores().remove(jug)) {
			ligaDAO.actualizaEquipo(eq);
			builder = Response.ok(jug);
			return builder.build();
		}

		builder= Response.status(Response.Status.NOT_FOUND);
		return builder.build();
	}

	/**
	 * Consultar ranking de goleadores (GET)
	 */
	@GET
	@Path("/goleadores")
	@Produces({"application/xml","application/json"})
	public Response getRankingGoleadores(@QueryParam("equipo") String equipo) {
				
		Response.ResponseBuilder builder;
		
		List<Jugador> jugadores = new ArrayList<Jugador>();
		
		if(equipo != null) {
			// Ranking de goleadores de un equipo
			Equipo eq = ligaDAO.getEquipo(equipo);
			if(eq != null) {
				jugadores = eq.getJugadores();
			}else {
				builder = Response.status(Response.Status.NOT_FOUND);
				return builder.build();	
			}
		} else {
			// Ranking de goleadores global
			jugadores = ligaDAO.getJugadores();
		}

		Collections.sort(jugadores);
		builder = Response.ok(new ListaJugadores(jugadores));
		return builder.build();
	}
}
