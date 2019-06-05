package es.unican.ss.LigaFutbolCliente.jornadadomain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tarjeta")
public class Tarjeta {
	
	private String tipo;
	private int dorsal;
	
	@XmlAttribute(name="tipo")
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@XmlAttribute(name="dorsal")
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

}
