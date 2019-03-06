/**
 * SegurosSSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package es.unican.ss.segurosss;

import es.unican.ss.dao.AseguradoraDAOImpl;
import es.unican.ss.dao.IClientesDAO;
import es.unican.ss.dao.ISegurosDAO;
import es.unican.ss.segurosdomain.Cliente;
import es.unican.ss.segurosdomain.Seguro;
import es.unican.ss.segurosss.types.DatosNoValidos;
import es.unican.ss.segurosss.types.InfoSeguro;
import es.unican.ss.segurosss.types.ListaSeguros;

/**
 *  SegurosSSSkeleton java skeleton for the axisService
 */
public class SegurosSSSkeleton {
	/**
	 * Auto generated method signature
	 * Retorna el tipo, precio y matrícula del vehículo asociado a un ID de seguro
	 * @param retornarDatosSeguro
	 * @return retornarDatosSeguroResponse
	 * @throws DatosNoValidosException
	 */
	public es.unican.ss.segurosss.types.InfoSeguro retornarDatosSeguro(
			java.lang.String retornarDatosSeguro) throws DatosNoValidosException {
		
		/*if(!retornarDatosSeguro.matches("^\\[A-Z]{3}-[0-9]{6}")) {
			DatosNoValidosException e = new DatosNoValidosException();
			DatosNoValidos d = new DatosNoValidos();
			d.setError("El formato del ID del seguro no es correcto");
			e.setFaultMessage(d);
			throw e; 
		}*/
		
		ISegurosDAO i = new AseguradoraDAOImpl();
		Seguro s = i.seguro(retornarDatosSeguro);
		
		if(s == null) {
			DatosNoValidosException e = new DatosNoValidosException();
			DatosNoValidos d = new DatosNoValidos();
			d.setError("El seguro no existe");
			e.setFaultMessage(d);
			throw e;
		}
		
		InfoSeguro is = new InfoSeguro();
		is.setMatricula(s.getVehiculo().getMatricula());
		is.setTipoSeguro(s.getTipoSeguro());
		is.setPrecio(s.calculaPrecio());
		
		return is;
	}
	
	/**
	 * Auto generated method signature
	 * Retorna la lista de seguros asociados al DNI de un cliente
	 * @param retornarListaSeguros
	 * @return retornarListaSegurosResponse
	 * @throws DatosNoValidosException
	 */
	public es.unican.ss.segurosss.types.ListaSeguros retornarListaSeguros(
			java.lang.String retornarListaSeguros) throws DatosNoValidosException {
		
		/*if(!retornarListaSeguros.matches("^\\d{8}[A-Z]{1}")) {
			DatosNoValidosException e = new DatosNoValidosException();
			DatosNoValidos d = new DatosNoValidos();
			d.setError("El formato del DNI del cliente no es correcto");
			e.setFaultMessage(d);
			throw e;
		}*/

		IClientesDAO i = new AseguradoraDAOImpl();
		Cliente c = i.cliente(retornarListaSeguros);
		ListaSeguros ls = new ListaSeguros();
		
		if(c == null) {
			DatosNoValidosException e = new DatosNoValidosException();
			DatosNoValidos d = new DatosNoValidos();
			d.setError("El cliente no existe");
			e.setFaultMessage(d);
			throw e;
		}
		
		ls.getSeguroCliente().addAll(c.getSeguros());
		return ls;
	}
}
