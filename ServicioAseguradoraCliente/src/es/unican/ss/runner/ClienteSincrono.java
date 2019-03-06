package es.unican.ss.runner;

import es.unican.www.ss.segurosss.DatosNoValidosException;
import es.unican.www.ss.segurosss.SegurosSSStub;

public class ClienteSincrono {
	public static void main(String[] args) {
		try {
			SegurosSSStub segurostub = new SegurosSSStub("http://localhost:8081/axis2/services/SegurosSS");
			
			//Casos de invocacion correcta
			try {
				System.out.println(segurostub.retornarListaSeguros("72391113E"));
			} catch (DatosNoValidosException e) {
				System.out.println("hola a");
				//System.out.println(e.getFaultMessage());
			}
			
			try {
				System.out.println(segurostub.retornarDatosSeguro("DEF-123456"));	
			} catch (DatosNoValidosException e) {
				System.out.println("hola b");
				//System.out.println(e.getFaultMessage());
			}

			//Casos de invocacion incorrecta
			try {
				System.out.println("hola b");
				System.out.println(segurostub.retornarListaSeguros("11111111A"));
				System.out.println("hola cdsda");

			}catch(DatosNoValidosException e) {
				System.out.println("hola c");
				//System.out.println(e.getFaultMessage());
				System.out.println(e.getFaultMessage());
			}
			
			try {
				System.out.println(segurostub.retornarDatosSeguro("AAA-000000"));
			}catch(DatosNoValidosException e) {
				System.out.println("hola d");
				System.out.println(e.getFaultMessage());
			}

		} catch (Exception e) {
			System.out.println("Fuera");
			e.printStackTrace();
		}
	}
}
