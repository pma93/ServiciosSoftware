package es.unican.ss.dao;

import es.unican.ss.segurosdomain.Cliente;

/**
 * Interfaz de acceso a datos de los clientes de la aseguradora 
 * 
 */
public interface IClientesDAO {
	
	/**
	 * Anhade un nuevo cliente a la aseguradora
	 * @param c Datos del cliente
	 * @return El cliente una vez anhadido
	 */
	public Cliente creaCliente(Cliente c);
	
	/**
	 * Retorna el cliente cuyo dni se pasa como parametro
	 * @param dni
	 * @return El cliente correspondiente al dni dado
	 *         null si no existe el cliente
	 */
	public Cliente cliente(String dni);
	
	/**
	 * Elimina al cliente que se pasa como parametro
	 * @param c El cliente que se quiere eliminar
	 * @return El cliente eliminado
	 * 		   Null si el cliente no existia
	 */
	public Cliente eliminaCliente(Cliente c);
	
	/**
	 * Actualiza el cliente con los datos que se pasan
	 * @param c Cliente a actualizar
	 * @return El cliente actualizado
	 */
	public Cliente actualizaCliente(Cliente c);

}
