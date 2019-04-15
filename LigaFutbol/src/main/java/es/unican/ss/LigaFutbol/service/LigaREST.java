package es.unican.ss.LigaFutbol.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import es.unican.ss.LigaFutbol.dao.ILigaDAO;
import es.unican.ss.LigaFutbol.dao.LigaDAOImp;

@Path("/liga")
public class LigaREST {
	
	public static final int MAXEQUIPOS = 20;
	public static final int MAXJUGADORESEQUIPO = 25;
	private ILigaDAO ligaDAO;
	
	public LigaREST() {
		ligaDAO = new  LigaDAOImp();
	}
	
	/**
	 * Consultar clasificacion Liga (GET)
	 */
	public Response getClasificacionLiga() {
		return null;
	}
	
	
	
	
}
