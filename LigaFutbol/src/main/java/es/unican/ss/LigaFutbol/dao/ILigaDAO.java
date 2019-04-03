package es.unican.ss.LigaFutbol.dao;

import java.util.List;

import es.unican.ss.LigaFutbol.domain.Equipo;
import es.unican.ss.LigaFutbol.domain.Jugador;

public interface ILigaDAO {

	/**
	 * Retorna la lista de equipos inscritos en la Liga
	 * 
	 * @return Lista de equipos de la liga
	 */
	public List<Equipo> getEquipos();

	/**
	 * Retorna el equipo cuyo nombre se pasa como par�metro
	 * 
	 * @param equipo
	 * @return El equipo o null si no existe
	 */
	public Equipo getEquipo(String equipo);

	/**
	 * Actualiza el equipo con los datos que se pasan como par�metro
	 * 
	 * @param e Nuevos datos del equipo
	 * @return El equipo actualizado o null si no se puede actualizar
	 */

	public Equipo actualizaEquipo(Equipo e);

	/**
	 * Retorna la lista completa de jugadores de la liga
	 * 
	 * @return Lista de jugadores inscritos en la liga
	 */
	public List<Jugador> getJugadores();

	/**
	 * Retorna el jugador cuyo equipo y dorsal se pasan como par�metros
	 * 
	 * @return Jugador
	 */
	public Jugador getJugador(String equipo, int dorsal);

	/**
	 * Actualiza el jugador cuyo equipo se pasa como par�metros
	 * 
	 * @return Jugador actualizado
	 */
	public Jugador actualizaJugador(String equipo, Jugador j);

}
