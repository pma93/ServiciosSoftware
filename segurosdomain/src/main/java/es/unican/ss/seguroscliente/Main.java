package es.unican.ss.seguroscliente;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import es.unican.ss.segurosSAX.AseguradoraHandler;
import es.unican.ss.segurosdomain.Aseguradora;
import es.unican.ss.segurosdomain.Cliente;
import es.unican.ss.segurosdomain.Seguro;
import es.unican.ss.segurosdomain.TipoSeguro;
import es.unican.ss.segurosdomain.Vehiculo;

public class Main {

	public static void main(String[] args) {

		// PARTE 5: Procesamiento de documentos XML con JAXB
		JAXBContext jaxbctx;
		try {

			jaxbctx = JAXBContext.newInstance(Aseguradora.class);
			// Procesamos el documento (Unmarshall)
			InputStream segurosDomainXml = Main.class.getClassLoader().getResourceAsStream("SegurosDomain.xml");
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			Aseguradora aseguradora = (Aseguradora) unmarshaller.unmarshal(segurosDomainXml);

			System.out.println("=== PARTE 5: Clientes ===");
			for (Cliente cliente : aseguradora.getClientes()) {
				System.out.print("DNI: " + cliente.getDni());
				double totalImporteSeguros = 0;

				for(Seguro seguro : cliente.getSeguros()) {
					totalImporteSeguros += seguro.calculaPrecio();
				}
				
				System.out.print(" Total a pagar: " + totalImporteSeguros + "€");
				System.out.println();
			}
			System.out.println("=============================");

			// Creación de nuevo cliente con seguro y volcado de la información a fichero xml de salida
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setMatricula("4328 AKL");
			vehiculo.setPotencia(300);
			vehiculo.setUsoProfesional(false);

			Seguro seguro = new Seguro();
			seguro.setId("QKK-923756");
			seguro.setTipoSeguro(TipoSeguro.TERCEROS);
			seguro.setVehiculo(vehiculo);
			List<Seguro> seguros = new LinkedList<Seguro>();
			seguros.add(seguro);

			Cliente cliente = new Cliente();
			cliente.setDni("72398855A");
			cliente.setNombre("Khien Estu");
			cliente.setEmail("khien.estu@gmail.com");
			cliente.setSeguros(seguros);

			aseguradora.getClientes().add(cliente);

			// Volcamos a un nuevo fichero xml (marshall)
			Marshaller marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(aseguradora, new File("SegurosDomain_v2.xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		// PARTE 6: Procesamiento de documentos XML con la API Java para SAX
		try {
			// Instanciar el parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			// Crear el manejador
			AseguradoraHandler handler = new AseguradoraHandler();
			
			System.out.println("=== PARTE 6: Clientes (SAX) ===");

			// Parsear el fichero
			saxParser.parse("src/main/resources/SegurosDomain.xml", handler);
			
			System.out.println("Numero de clientes: " + handler.getNumClientes());
			System.out.println("=============================");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
