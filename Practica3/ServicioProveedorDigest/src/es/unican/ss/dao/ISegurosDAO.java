package es.unican.ss.dao;

import es.unican.ss.segurosdomain.Seguro;

/**
 * Interfaz de acceso a datos de los clientes de la aseguradora
 */
public interface ISegurosDAO {
	
	/**
	 * Anhade un nuevo seguro
	 * @param s seguro
	 * @return El seguro una vez anhadido
	 */
	public Seguro creaSeguro(Seguro s);
	
	/**
	 * Retorna el seguro cuyo identificador 
       * se pasa como parametro
	 * @param idSeguro
	 * @return Seguro con id = idSeguro
      *         null si no se encuentra
	 */
	public Seguro seguro(String idSeguro);
	
}
