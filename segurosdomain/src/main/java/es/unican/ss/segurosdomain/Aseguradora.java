package es.unican.ss.segurosdomain;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "aseguradora")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Aseguradora implements Serializable {
	
	@XmlElement(name="cliente", required=true)
	protected List<Cliente> clientes;
	
	public Aseguradora() {}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
