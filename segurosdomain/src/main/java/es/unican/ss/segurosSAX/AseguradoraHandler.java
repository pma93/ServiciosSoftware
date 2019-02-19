package es.unican.ss.segurosSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AseguradoraHandler extends DefaultHandler {
	
	private String dniCliente = null;
	private String idSeguro = null;
	private String fecha = null;
	private String seguroref = null;
	private int numClientes = 0;
	
	private String texto = null;
		
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Comienzo del parseo");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Finalización del parseo");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("tns:cliente")) {
			dniCliente = attrs.getValue("dni");
			System.out.println("DNI: " + dniCliente);
			numClientes++;
		} else if (qName.equals("tns:seguro")) {
			idSeguro = attrs.getValue("id");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "tns:fecha":
			fecha = texto;
			break;
		case "tns:seguroref":
			seguroref = texto;
			if (!seguroref.equals(idSeguro)) {
				System.out.println("El parte de accidente con fecha " + fecha 
						+ " no pertenece a ningun seguro valido");
			}
		}	
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto = new String(ch, start, length).trim(); 
	}

	public int getNumClientes() {
		return numClientes;
	}

	public void setNumClientes(int numClientes) {
		this.numClientes = numClientes;
	}
}
