package es.unican.ss.LigaFutbol.dao;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.unican.ss.LigaFutbol.domain.Equipo;
import es.unican.ss.LigaFutbol.domain.Jugador;
import es.unican.ss.LigaFutbol.domain.Liga;

public class LigaDAOImp implements ILigaDAO {
	
	public List<Equipo> getEquipos() {
		return getLiga().getEquipos();
	}

	public Equipo getEquipo(String equipo) {
		for(Equipo e : getEquipos()) {
			if(e.getNombre().equals(equipo))
				return e;
		}
		return null;
	}

	public Equipo actualizaEquipo(Equipo e) {
		Liga liga = getLiga();
		for(Equipo equipoDao : liga.getEquipos()) {
			if(equipoDao.getNombre().equals(e.getNombre())) {
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

	public List<Jugador> getJugadores() {
		List<Jugador> jugadores = new ArrayList<Jugador>();

		for(Equipo e : getEquipos()) {
			jugadores.addAll(e.getJugadores());
		}

		return jugadores;
	}

	public Jugador getJugador(String equipo, int dorsal) {
		for(Jugador jugador : getEquipo(equipo).getJugadores()) {
			if(jugador.getDorsal() == dorsal)
				return jugador;
		}
		return null;
	}

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

	private Liga getLiga() {
		JAXBContext jaxbctx;
		Unmarshaller unmarshaller;
		Liga liga = null;
		// Procesamos el documento (unmarshall) a partir del contexto JAXB basado en 'Liga'
		try {
			jaxbctx = JAXBContext.newInstance(Liga.class);
			InputStream ligaXml = this.getClass().getResourceAsStream("primeraDivision.xml");
			unmarshaller = jaxbctx.createUnmarshaller();
			liga = (Liga) unmarshaller.unmarshal(ligaXml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return liga;
	}

	private void saveLiga(Liga liga) {
		JAXBContext jaxbctx;
		Marshaller marshaller;
		// Guardamos el documento (marshall) a partir del contexto JAXB basado en 'Liga'
		try {
			jaxbctx = JAXBContext.newInstance(Liga.class);
			marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(liga, new File(this.getClass().getResource("primeraDivision.xml").getPath()));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}