package es.unican.ss.SSGasolineras;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * MunicipioHandler
 * 
 * Manejador para obtener de un fichero XML 
 * el identificador del municipio cuyo nombre es proporcionado.
*/
public class MunicipioHandler extends DefaultHandler {

	// Si se desea mostrar o no información de log por consola
	private static boolean LOGGING_ENABLED = false;

	// La id del municipio proporcionado
	private String idMunicipio;
	
	// Almacenamiento temporal de valores para parseo
	private String idMunicipioActual;
	private String nombreMunicipio;
	private String texto;
	
	public MunicipioHandler(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	
	@Override
	public void startDocument() throws SAXException {
		if(LOGGING_ENABLED)
		System.out.println("Log MunicipioHandler: Comienzo del parseo");
	}
	
	@Override
	public void endDocument() throws SAXException {
		if(LOGGING_ENABLED)
		System.out.println("Log MunicipioHandler: Finalización del parseo");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if(LOGGING_ENABLED)
		System.out.println("Log MunicipioHandler: Comienzo del elemento " + qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "IDMunicipio":
			idMunicipioActual = texto;
			break;
		case "Municipio":
			if (texto.equals(nombreMunicipio))
				idMunicipio = idMunicipioActual;
			break;
		}	
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto = new String(ch, start, length).trim(); 
	}

	public String getIdMunicipio() {
		return this.idMunicipio;
	}
}
