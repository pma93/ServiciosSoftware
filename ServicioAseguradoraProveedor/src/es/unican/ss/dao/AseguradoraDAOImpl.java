package es.unican.ss.dao;

import es.unican.ss.segurosdomain.Aseguradora;
import es.unican.ss.segurosdomain.Cliente;
import es.unican.ss.segurosdomain.Seguro;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class AseguradoraDAOImpl implements IClientesDAO, ISegurosDAO{

	@Override
	public Seguro creaSeguro(Seguro s) {
		return null;
	}

	@Override
	public Seguro seguro(String idSeguro) {
		Seguro sg= null;
		JAXBContext jaxbctx;
		try {
			jaxbctx = JAXBContext.newInstance(Aseguradora.class);
			// Procesamos el documento (Unmarshall)
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			
			Aseguradora a = (Aseguradora) unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream("META-INF/SegurosDomain.xml"));
			
			for (Cliente c : a.getClientes()) {
				for(Seguro s : c.getSeguros()) {
						if(s.getId().equals(idSeguro)) {
							sg = s;
						}
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return sg;
	}

	@Override
	public Cliente creaCliente(Cliente c) {
		return null;
	}

	@Override
	public Cliente cliente(String dni) {
		Cliente cl= null;
		JAXBContext jaxbctx;
		try {
			jaxbctx = JAXBContext.newInstance(Aseguradora.class);
			// Procesamos el documento (Unmarshall)
			Unmarshaller unmarshaller = jaxbctx.createUnmarshaller();
			
			Aseguradora a = (Aseguradora) unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream("META-INF/SegurosDomain.xml"));
			
			for (Cliente c : a.getClientes()) {
				if(c.getDni().equals(dni)) {
					cl=c;
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return cl;
	}

	@Override
	public Cliente eliminaCliente(Cliente c) {
		return null;
	}

	@Override
	public Cliente actualizaCliente(Cliente c) {
		return null;
	}
}
