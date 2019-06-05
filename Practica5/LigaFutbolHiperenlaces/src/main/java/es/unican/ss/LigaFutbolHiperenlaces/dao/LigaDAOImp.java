package es.unican.ss.LigaFutbolHiperenlaces.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.unican.ss.LigaFutbolHiperenlaces.domain.Equipo;
import es.unican.ss.LigaFutbolHiperenlaces.domain.Jugador;
import es.unican.ss.LigaFutbolHiperenlaces.domain.Liga;

public class LigaDAOImp implements ILigaDAO {
	
	/**
	 * Retorna la lista de equipos inscritos en la Liga
	 * 
	 * @return Lista de equipos de la liga
	 */
	@Override
	public List<Equipo> getEquipos() {
		return getLiga().getEquipos();
	}

	/**
	 * Retorna el equipo cuyo nombre se pasa como parámetro
	 * 
	 * @param equipo
	 * @return El equipo o null si no existe
	 */
	@Override
	public Equipo getEquipo(String equipo) {
		for(Equipo e : getEquipos()) {
			if(e.getNombre().equals(equipo))
				return e;
		}
		return null;
	}

	/**
	 * Actualiza el equipo con los datos que se pasan como parámetro
	 * 
	 * @param e Nuevos datos del equipo
	 * @return El equipo actualizado o null si no se puede actualizar
	 */
	@Override
	public Equipo actualizaEquipo(Equipo e) {
		Liga liga = getLiga();
		for(Equipo equipoDao : liga.getEquipos()) {
			if(equipoDao.getNombre().equals(e.getNombre())) {
				equipoDao.setJugadores(e.getJugadores());
				equipoDao.setPartidosGanados(e.getPartidosGanados());
				equipoDao.setPartidosJugados(e.getPartidosJugados());
				equipoDao.setPartidosPerdidos(e.getPartidosPerdidos());
				equipoDao.setPuntos(e.getPuntos());
				saveLiga(liga);
				return equipoDao;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista completa de jugadores de la liga
	 * 
	 * @return Lista de jugadores inscritos en la liga
	 */
	@Override
	public List<Jugador> getJugadores() {
		List<Jugador> jugadores = new ArrayList<Jugador>();

		for(Equipo e : getEquipos()) {
			jugadores.addAll(e.getJugadores());
		}

		return jugadores;
	}

	/**
	 * Retorna el jugador cuyo equipo y dorsal se pasan como parámetros
	 * 
	 * @return Jugador
	 */
	@Override
	public Jugador getJugador(String equipo, int dorsal) {
		for(Jugador jugador : getEquipo(equipo).getJugadores()) {
			if(jugador.getDorsal() == dorsal)
				return jugador;
		}
		return null;
	}

	/**
	 * Actualiza el jugador cuyo equipo se pasa como parámetros
	 * 
	 * @return Jugador actualizado
	 */
	@Override
	public Jugador actualizaJugador(String equipo, Jugador j) {		
		Liga liga = getLiga();
		for(Equipo e : liga.getEquipos()) {
			if(e.getNombre().equals(equipo)) {
				for(Jugador jugadorDao : e.getJugadores()) {
					if(jugadorDao.getDorsal() == j.getDorsal()) {
						jugadorDao.setGoles(j.getGoles());
						jugadorDao.setTarjetasAmarillas(j.getTarjetasAmarillas());
						jugadorDao.setTarjetasRojas(j.getTarjetasRojas());
						saveLiga(liga);
						return jugadorDao;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Procesa el documento (unmarshall) 
	 * a partir del contexto JAXB basado en 'Liga'
	 * 
	 * @return liga
	 */
	private Liga getLiga() {
		JAXBContext jaxbctx;
		Unmarshaller unmarshaller;
		Liga liga = null;
		// Procesamos el documento (unmarshall)
		try {
			jaxbctx = JAXBContext.newInstance(Liga.class);
			InputStream ligaXml = null;
			ligaXml = new FileInputStream("/Users/fernando/Desktop/primeraDivision.xml");
			unmarshaller = jaxbctx.createUnmarshaller();
			liga = (Liga) unmarshaller.unmarshal(ligaXml);
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return liga;
	}

	/**
	 * Guarda el documento (marshall) 
	 * a partir del contexto JAXB basado en 'Liga'
	 * 
	 * @param liga
	 */
	private void saveLiga(Liga liga) {
		JAXBContext jaxbctx;
		Marshaller marshaller;
		// Guardamos el documento (marshall) 
		try {
			jaxbctx = JAXBContext.newInstance(Liga.class);
			marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(liga, new File("/Users/fernando/Desktop/primeraDivision.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}