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
			// Procesamos el documento (unmarshall) a partir del contexto JAXB
			jaxbctx = JAXBContext.newInstance(Aseguradora.class);
			InputStream segurosDomainXml = Main.class.getClassLoader().getResourceAsStream("SegurosDomain.xml");
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			Aseguradora aseguradora = (Aseguradora) unmarshaller.unmarshal(segurosDomainXml);

			// Mostrado de clientes y calculo del importe total de sus seguros
			System.out.println("=== PARTE 5: Clientes ===");
			double totalImporteSeguros;
			for (Cliente cliente : aseguradora.getClientes()) {
				System.out.print("DNI: " + cliente.getDni());
				totalImporteSeguros = 0;

				for (Seguro seguro : cliente.getSeguros()) {
					totalImporteSeguros += seguro.calculaPrecio();
				}

				System.out.print(" Total a pagar: " + totalImporteSeguros + "€");
				System.out.println();
			}
			System.out.println("=============================");

			// Creacion de un vehiculo
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setMatricula("4328 AKL");
			vehiculo.setPotencia(300);
			vehiculo.setUsoProfesional(false);

			// Nuevo seguro que tiene como vehiculo el anterior creado
			Seguro seguro = new Seguro();
			seguro.setId("QKK-923756");
			seguro.setTipoSeguro(TipoSeguro.TERCEROS);
			seguro.setVehiculo(vehiculo);
			List<Seguro> seguros = new LinkedList<Seguro>();
			seguros.add(seguro);

			// Creacion de cliente con el vehiculo y seguro anteriores
			Cliente cliente = new Cliente();
			cliente.setDni("72398855A");
			cliente.setNombre("Khien Stu");
			cliente.setEmail("khien.stu@unican.es");
			cliente.setSeguros(seguros);

			// Se anhade el cliente al listado con el que ya se contaba
			aseguradora.getClientes().add(cliente);

			// Volcado (marshall) del estado actual a un nuevo fichero xml 
			// Se escribira en el mismo directorio desde donde se ejecuta el programa
			Marshaller marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(aseguradora, new File("SegurosDomain_AutoOutput.xml"));

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
			InputStream segurosDomainXml = Main.class.getClassLoader().getResourceAsStream("SegurosDomain.xml");
			saxParser.parse(segurosDomainXml, handler);

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
