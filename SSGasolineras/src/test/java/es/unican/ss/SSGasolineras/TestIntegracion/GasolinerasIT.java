package es.unican.ss.SSGasolineras.TestIntegracion;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.unican.ss.SSGasolineras.DatosNoDisponibles;
import es.unican.ss.SSGasolineras.GasolineraInterface;
import es.unican.ss.SSGasolineras.Gasolineras;
import es.unican.ss.SSGasolineras.MunicipioNoValido;

public class GasolinerasIT {
	
	Endpoint endpoint;
	URL url;
	QName serviceQName;
	QName portQName;
	Service service;
	GasolineraInterface sut;
	
	@Before
	public void setUp() {
		endpoint = Endpoint.publish("http://localhost:8080/SSGasolineras-0.0.1-SNAPSHOT", new Gasolineras()); 
		try {
			url = new URL("http://localhost:8080/SSGasolineras-0.0.1-SNAPSHOT?wsdl");
			serviceQName = new QName("http://www.unican.es/ss/SSGasolineras", "GasolinerasService"); 
			portQName = new QName("http://www.unican.es/ss/SSGasolineras", "GasolinerasPort");
			service = Service.create(url, serviceQName);
			sut = service.getPort(portQName, GasolineraInterface.class); 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		endpoint.stop();
	}
	
	/**
	 * Test para comprobar que el numero de gasolineras del municipio
	 * indicado es el correcto
	 */
	@Test
	public void testRetornarListaGasolineras() {
		System.out.println("Realizando el test: testRetornarListaGasolineras");
		try {
			Assert.assertEquals(sut.retornarListaGasolineras("Santander").size(), 22);
		} catch (MunicipioNoValido e) {
			Assert.fail("Se ha lanzado la excepción MunicipioNoValido y no se esperaba");
		} catch (DatosNoDisponibles e) {
			Assert.fail("Se ha lanzado la excepción DatosNoDisponibles y no se esperaba");
		}
	}

	/**
	 * Test para comprobar que la gasolinera del municipio
	 * indicado es la mas barata
	 */
	@Test
	public void testRetornarGasolineraPrecioMasBarato() {
		System.out.println("Realizando el test: testRetornarGasolineraPrecioMasBarato");
		try {
			Assert.assertEquals(sut.retornarGasolineraPrecioMasBarato("Santander").getDireccion(),
					"ISLA DEL OLEO 19 - POL. IND. NUEVA MONTAÑA");
		} catch (MunicipioNoValido e) {
			Assert.fail("Se ha lanzado la excepción MunicipioNoValido y no se esperaba");
		} catch (DatosNoDisponibles e) {
			Assert.fail("Se ha lanzado la excepción DatosNoDisponibles y no se esperaba");
		}
	}
	
	/**
	 * Test para comprobar que se lanza la excepcion MunicipioNoValido
	 * para la operación RetornarGasolineraPrecioMasBarato
	 */
	@Test
	public void testRetornarGasolineraPrecioMasBaratoMunicipioNoValido() {
		System.out.println("Realizando el test: testRetornarGasolineraPrecioMasBaratoMunicipioNoValido");
		try {
			Assert.assertEquals(sut.retornarGasolineraPrecioMasBarato("MunicipioInventado").getDireccion(), null);
			Assert.fail("Se debería haber lanzado la excepción MunicipioNoValido");
		} catch (MunicipioNoValido e) {
			Assert.assertTrue(e instanceof MunicipioNoValido);
		} catch (DatosNoDisponibles e) {
			Assert.fail("Se ha lanzado la excepción DatosNoDisponibles y no se esperaba");
		}
	}
	
	/**
	 * Test para comprobar que se lanza la excepcion MunicipioNoValido
	 * para la operación RetornarListaGasolineras
	 */
	@Test
	public void testRetornarListaGasolinerasMunicipioNoValido() {
		System.out.println("Realizando el test: testRetornarListaGasolinerasMunicipioNoValido");
		try {
			Assert.assertEquals(sut.retornarListaGasolineras("MunicipioInventado").size(), 0);
			Assert.fail("Se debería haber lanzado la excepción MunicipioNoValido");
		} catch (MunicipioNoValido e) {
			Assert.assertTrue(e instanceof MunicipioNoValido);
		} catch (DatosNoDisponibles e) {
			Assert.fail("Se ha lanzado la excepción DatosNoDisponibles y no se esperaba");
		}
	}
	
	/**
	 * Test para comprobar que se lanza la excepcion DatosNoDisponibles
	 * para la operación RetornarListaGasolineras
	 */
	@Test
	public void testRetornarListaGasolinerasMunicipioDatosNoDisponibles() {
		System.out.println("Realizando el test: testRetornarListaGasolinerasMunicipioDatosNoDisponibles");
		try {
			Assert.assertEquals(sut.retornarListaGasolineras("Noja").size(), 0);
			Assert.fail("Se debería haber lanzado la excepción DatosNoDisponibles");
		} catch (MunicipioNoValido e) {
			Assert.fail("Se ha lanzado la excepción MunicipioNoValido y no se esperaba");
		} catch (DatosNoDisponibles e) {
			Assert.assertTrue(e instanceof DatosNoDisponibles);
		}
	}
	
	/**
	 * Test para comprobar que se lanza la excepcion DatosNoDisponibles
	 * para la operación RetornarGasolineraPrecioMasBarato
	 */
	@Test
	public void testRetornarGasolineraPrecioMasBaratoDatosNoDisponibles() {
		System.out.println("Realizando el test: testRetornarGasolineraPrecioMasBaratoDatosNoDisponibles");
		try {
			Assert.assertEquals(sut.retornarGasolineraPrecioMasBarato("Noja").getDireccion(), null);
			Assert.fail("Se debería haber lanzado la excepción DatosNoDisponibles");
		} catch (MunicipioNoValido e) {
			Assert.fail("Se ha lanzado la excepción MunicipioNoValido y no se esperaba");
		} catch (DatosNoDisponibles e) {
			Assert.assertTrue(e instanceof DatosNoDisponibles);
		}
	}
}
