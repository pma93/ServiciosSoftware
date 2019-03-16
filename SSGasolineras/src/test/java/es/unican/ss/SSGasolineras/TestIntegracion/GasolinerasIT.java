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
		endpoint = Endpoint.publish("http://localhost:8080/SSGasolineras-0.0.1-SNAPSHOT"
				, new Gasolineras()); 
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
	
	@Test
	public void testRetornarListaGasolineras() {
		try {
			Assert.assertEquals(sut.retornarListaGasolineras("Santander").size(), 23);
		} catch (DatosNoDisponibles e) {
			e.printStackTrace();
		} catch (MunicipioNoValido e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRetornarGasolineraPrecioMasBarato() {
		try {
			Assert.assertEquals(sut.retornarGasolineraPrecioMasBarato("Santander").getDireccion(),
					"ISLA DEL OLEO 19 - POL. IND. NUEVA MONTAÑA");
		} catch (DatosNoDisponibles e) {
			e.printStackTrace();
		} catch (MunicipioNoValido e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRetornarGasolineraPrecioMasBaratoNoValido()  {
		try {
			Assert.assertEquals(sut.retornarGasolineraPrecioMasBarato("MunicipioInventado").getDireccion(),
					null);
		} catch (MunicipioNoValido e) {
			e.printStackTrace();
		} catch (DatosNoDisponibles e) {
			e.printStackTrace();
		}
	}
}
