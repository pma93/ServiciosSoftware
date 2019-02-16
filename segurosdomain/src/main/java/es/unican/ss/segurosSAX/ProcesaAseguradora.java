package es.unican.ss.segurosSAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ProcesaAseguradora {
	
	public static void main(String[] args) {

		try {

			// Instanciar el parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			// Crear el manejador
			AseguradoraHandler handler = new AseguradoraHandler();
			
			// Parsear el fichero
			saxParser.parse("src/main/resources/SegurosDomain.xml", handler);
			
			System.out.println("Numero de clientes: " + handler.getNumClientes());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
