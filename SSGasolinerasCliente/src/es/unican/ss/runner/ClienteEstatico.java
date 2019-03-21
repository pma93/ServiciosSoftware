package es.unican.ss.runner;

import es.unican.ss.ssgasolineras.DatosNoDisponibles_Exception;
import es.unican.ss.ssgasolineras.GasolineraInterface;
import es.unican.ss.ssgasolineras.GasolinerasService;
import es.unican.ss.ssgasolineras.MunicipioNoValido_Exception;

public class Cliente {

	public static void main(String[] args) {
		GasolinerasService gasolineraService = new GasolinerasService(); 
		GasolineraInterface gasolineraPort = gasolineraService.getGasolinerasPort();
		
		System.out.println("Cliente arrancado...");
		
		// Casos válidos
		try {
			System.out.println(gasolineraPort.retornarListaGasolineras("Medio Cudeyo"));
		} catch (DatosNoDisponibles_Exception e) {
			e.printStackTrace();
		} catch (MunicipioNoValido_Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(gasolineraPort.retornarGasolineraPrecioMasBarato("Medio Cudeyo"));
		} catch (DatosNoDisponibles_Exception e) {
			e.printStackTrace();
		} catch (MunicipioNoValido_Exception e) {
			e.printStackTrace();
		}
		
		// Casos de excepción "Municipio no válido"
		try {
			System.out.println(gasolineraPort.retornarListaGasolineras("MunicipioInventado"));
		} catch (DatosNoDisponibles_Exception e) {
			System.out.println("DatosNoDisponibles: Se ha producido un error");
		} catch (MunicipioNoValido_Exception e) {
			System.out.println("MunicipioNoValido: Se ha producido un error");
		}
		
		try {
			System.out.println(gasolineraPort.retornarGasolineraPrecioMasBarato("MunicipioInventado"));
		} catch (DatosNoDisponibles_Exception e) {
			System.out.println("DatosNoDisponibles: Se ha producido un error");
		} catch (MunicipioNoValido_Exception e) {
			System.out.println("MunicipioNoValido: Se ha producido un error");
		}
		
		
		// Casos de excepción "Datos no disponibles"
		try {
			System.out.println(gasolineraPort.retornarListaGasolineras("Noja"));
		} catch (DatosNoDisponibles_Exception e) {
			System.out.println("DatosNoDisponibles: Se ha producido un error");
		} catch (MunicipioNoValido_Exception e) {
			System.out.println("MunicipioNoValido: Se ha producido un error");
		}
		
		try {
			System.out.println(gasolineraPort.retornarGasolineraPrecioMasBarato("Noja"));
		} catch (DatosNoDisponibles_Exception e) {
			System.out.println("DatosNoDisponibles: Se ha producido un error");
		} catch (MunicipioNoValido_Exception e) {
			System.out.println("MunicipioNoValido: Se ha producido un error");
		}
	}

}
