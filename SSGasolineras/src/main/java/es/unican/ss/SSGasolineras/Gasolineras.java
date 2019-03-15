package es.unican.ss.SSGasolineras;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Gasolineras
 * 
 * Implementa el servicio web definido en el contrato 
 * GasolineraInterface.
*/
@WebService(endpointInterface="es.unican.ss.SSGasolineras.GasolineraInterface",
			targetNamespace="http://www.unican.es/ss/SSGasolineras")
public class Gasolineras implements GasolineraInterface {

	// Identificiador de la provincia sobre la que se basan las peticiones (Cantabria = 39)
	private static int ID_PROVINCIA_CANTABRIA = 39;
	
	// Ubicación de la API para obtener los precios de carburantes
	private static String PRECIO_CARBURANTES_API_ENDPOINT = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/";

	@Override
	public List<Gasolinera> retornarListaGasolineras(String municipio) throws DatosNoDisponibles, MunicipioNoValido {		
		try {
			String idMunicipio = getIdMunicipio(municipio);
			if(idMunicipio != null) {
				List<Gasolinera> todasGasolinerasMunicipio = getGasolinerasMunicipio(idMunicipio);
				if(todasGasolinerasMunicipio.isEmpty()) {
					throw new DatosNoDisponibles();
				} else {
					Collections.sort(todasGasolinerasMunicipio);
					return todasGasolinerasMunicipio;	
				}
			} else {
				throw new MunicipioNoValido();
			}
		} catch (IOException | SAXException | ParserConfigurationException e) {
			throw new DatosNoDisponibles();
		}
	}
	
	@Override
	public Gasolinera retornarGasolineraPrecioMasBarato(String municipio) throws DatosNoDisponibles, MunicipioNoValido {
		return retornarListaGasolineras(municipio).get(0);
	}
	
    /**
    * Obtener la id de un municipio en base a su nombre
    * 
    * @param municipio Nombre del municipio
    */
	private String getIdMunicipio(String municipio) throws IOException, SAXException, ParserConfigurationException {
		MunicipioHandler municipioHandler = new MunicipioHandler(municipio);
		String request = "Listados/MunicipiosPorProvincia/" + ID_PROVINCIA_CANTABRIA;
		handleRequest(request, municipioHandler);
		return municipioHandler.getIdMunicipio();
	}
	
    /**
    * Obtener las estaciones que se encuentran en un municipio
    * 
    * @param idMunicipio Identificador del municipio
    */
	private List<Gasolinera> getGasolinerasMunicipio(String idMunicipio) throws ParserConfigurationException, SAXException, IOException {
		EstacionesHandler estacionesHandler = new EstacionesHandler();
		String request = "EstacionesTerrestres/FiltroMunicipio/" + idMunicipio;
		handleRequest(request, estacionesHandler);
		return estacionesHandler.getListaGasolineras();
	}
	
    /**
    * Manejar una petición de la API
    * 
    * @param request Petición a la API
    * @param handler Manejador con el que parseará el resultado de la petición
    */
	private void handleRequest(String request, DefaultHandler handler) throws SAXException, IOException, ParserConfigurationException {		
		// Utilería para realizar el parseo
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		
		// Realizar petición y almacenar respuesta
		URL requestUrl = new URL(PRECIO_CARBURANTES_API_ENDPOINT + request);
		InputStream inputStream = requestUrl.openStream();
		
		// Manejar respuesta
		saxParser.parse(inputStream, handler);	
	}

}
