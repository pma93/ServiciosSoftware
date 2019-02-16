package es.unican.ss.seguroscliente;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.unican.ss.segurosdomain.Aseguradora;
import es.unican.ss.segurosdomain.Cliente;
import es.unican.ss.segurosdomain.Seguro;
import es.unican.ss.segurosdomain.TipoSeguro;
import es.unican.ss.segurosdomain.Vehiculo;

public class Main {

	public static void main(String[] args) {

		JAXBContext jaxbctx;
		try {

			jaxbctx = JAXBContext.newInstance(Aseguradora.class);
			// Procesamos el documento (Unmarshall)
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			Aseguradora aseguradora = (Aseguradora) unmarshaller.unmarshal(new File("src/main/resources/SegurosDomain.xml"));

			for (Cliente cliente : aseguradora.getClientes()) {
				System.out.print("DNI: " + cliente.getDni());
				double totalImporteSeguros = 0;

				for(Seguro seguro : cliente.getSeguros()) {
					totalImporteSeguros += seguro.calculaPrecio();
				}
				
				System.out.print(" Total a pagar: " + totalImporteSeguros + "€");
				System.out.println();
			}

			// Creación de nuevo cliente con seguro y volcado de la información a fichero xml de salida
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setMatricula("4328 AKL");
			vehiculo.setPotencia(300);
			vehiculo.setUsoProfesional(false);

			Seguro seguro = new Seguro();
			seguro.setId("1");
			seguro.setTipoSeguro(TipoSeguro.TERCEROS);
			seguro.setVehiculo(vehiculo);
			List<Seguro> seguros = new LinkedList<Seguro>();
			seguros.add(seguro);

			Cliente cliente = new Cliente();
			cliente.setDni("72398855A");
			cliente.setNombre("Khien Estu");
			cliente.setEmail("khien.estu@gmail.com");
			cliente.setSeguro(seguros);

			aseguradora.getClientes().add(cliente);

			// Volcamos a un nuevo fichero xml (marshall)
			Marshaller marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(aseguradora, new File("src/main/resources/SegurosDomain_v2.xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
