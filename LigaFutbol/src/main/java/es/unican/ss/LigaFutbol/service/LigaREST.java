package es.unican.ss.LigaFutbol.service;

import java.net.URI;
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

@Path("/liga")
public class LigaREST {

	private ILigaDAO ligaDAO;

	public LigaREST() {
		ligaDAO = new LigaDAOImp();
	}

	/**
	 * Consultar clasificacion Liga (GET)
	 */
	public Response getClasificacionLiga() {
		//TODO
		return null;
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

		if(eq == null) {
			builder= Response.status(Response.Status.NOT_FOUND);
		}else {
			builder = Response.ok(eq);
		}

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
	public Response updateEqupio(@PathParam("nombreEquipo") String nombre, Equipo equipo) {

		Response.ResponseBuilder builder;

		Equipo eq = ligaDAO.actualizaEquipo(equipo);

		if(eq == null) {
			builder= Response.status(Response.Status.NOT_FOUND);
		}else {
			builder = Response.ok(eq);
		}

		return builder.build();	
	}

	/**
	 * Anhadir un jugador a un equipo (POST)
	 */
	@POST
	@Path("/{nombreEquipo}/{dorsal}")
	@Consumes("application/xml")
	@Produces({"application/xml","application/json"})
	public Response addJugadorEquipo(@PathParam("nombreEquipo") String equipo,
			@PathParam("dorsal") int dorsal, @Context UriInfo uriInfo, Jugador jugador) {
		
		Response.ResponseBuilder builder;
		
		Equipo eq = ligaDAO.getEquipo(equipo);
		
		for(Jugador j : eq.getJugadores()) {
			if(j.getDorsal() == dorsal) {
				//Ya existe un recurso con ese URI
				builder = Response.status(Response.Status.CONFLICT);
			}
		}
		
		// Si no existe ya, se añade
		if(eq.getJugadores().add(jugador)) {
			ligaDAO.actualizaEquipo(eq);
			URI location = uriInfo.getAbsolutePathBuilder().build(); 
			builder = Response.created(location);
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

		Equipo eq = ligaDAO.getEquipo(equipo);
		Jugador jugador = ligaDAO.getJugador(equipo, dorsal);

		for(Jugador j : eq.getJugadores()) {
			if(j.getDorsal() == dorsal) {
				jugador = j;
			}
		}

		if(jugador == null) {
			builder = Response.status(Response.Status.NOT_FOUND);
		}else {
			builder = Response.ok(jugador);
		}

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
		
		Equipo eq = ligaDAO.getEquipo(equipo);
		Jugador jug = null;
		
		for(Jugador j : eq.getJugadores()) {
			if(j.getDorsal() == dorsal) {
				jug = j;
			}
		}
		
		if(jug == null) {
			builder= Response.status(Response.Status.NOT_FOUND);
		}else {
			jug.setGoles(jugador.getGoles());
			jug.setTarjetasAmarillas(jugador.getTarjetasAmarillas());
			jug.setTarjetasRojas(jugador.getTarjetasRojas());
			ligaDAO.actualizaEquipo(eq);
			builder = Response.ok(jug);
		}
		
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
		Jugador jugador = null;

		for(Jugador j : eq.getJugadores()) {
			if(j.getDorsal() == dorsal) {
				jugador = j;
			}
		}

		if(jugador == null) {
			builder= Response.status(Response.Status.NOT_FOUND);
		}else {
			builder = Response.ok(jugador);
		}

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

		List<Jugador> listaJugadores = new ArrayList<Jugador>();

		for(Equipo e : ligaDAO.getEquipos()) {
			listaJugadores.addAll(e.getJugadores());
			Collections.sort(listaJugadores);
			if(e.getNombre().equals(equipo)) {
				builder = Response.ok(listaJugadores);
				return builder.build();
			} else {
				builder = Response.ok(listaJugadores);
				return builder.build();
			}
		}

		builder = Response.status(Response.Status.NOT_FOUND);
		return builder.build();	
	}
}
