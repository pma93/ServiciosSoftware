package es.unican.ss.SSGasolineras;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * EstacionesHandler
 * 
 * Manejador para obtener de un fichero XML 
 * el listado de todas las estaciones de gasolinera 
 * con su dirección, rótulo, localidad y precio.
*/
public class EstacionesHandler extends DefaultHandler {
	
	// Si se desea mostrar o no información de log por consola
	private static boolean LOGGING_ENABLED = false;

	// Listado de gasolineras parseadas
	private List<Gasolinera> gasolineras = null;
	
	// Almacenamiento temporal de valores para parseo
	private String gasolineraDireccion;
	private String gasolineraRotulo;
	private String gasolineraLocalidad;
	private String precio;
	private String texto;
	
	public EstacionesHandler() {
		this.gasolineras = new ArrayList<Gasolinera>();
	}
	
	@Override
	public void startDocument() throws SAXException {
		if(LOGGING_ENABLED)
		System.out.println("Log EstacionesHandler: Comienzo del parseo");
	}
	
	@Override
	public void endDocument() throws SAXException {
		if(LOGGING_ENABLED)
		System.out.println("Log EstacionesHandler: Finalización del parseo");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if(LOGGING_ENABLED)
		System.out.println("Log EstacionesHandler: Comienzo del elemento " + qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(LOGGING_ENABLED)
		System.out.println("Log EstacionesHandler: Fin del elemento " + qName);
		
		switch (qName) {
			case "Dirección":
				gasolineraDireccion = texto;
				break;
			case "Localidad":
				gasolineraLocalidad = texto;
				break;
			case "Precio_x0020_Gasolina_x0020_95_x0020_Protección":
				precio = texto;
				break;
			case "Rótulo":
				gasolineraRotulo = texto;
				Gasolinera gasolinera = new Gasolinera();
				gasolinera.setDireccion(gasolineraDireccion);
				gasolinera.setLocalidad(gasolineraLocalidad);
				try {
					gasolinera.setPrecio(NumberFormat.getInstance().parse(precio).doubleValue());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				gasolinera.setRotulo(gasolineraRotulo);
				this.gasolineras.add(gasolinera);
				break;
		}	
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto = new String(ch, start, length).trim(); 
	}

	public List<Gasolinera> getListaGasolineras() {
		return this.gasolineras;
	}

}
