package es.unican.ss.LigaFutbolCliente.jornadadomain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gol")
public class Gol {

	private int dorsal;
	private int minuto;
	
	@XmlAttribute(name="dorsal")
	public int getDorsal() {
		return dorsal;
	}
	
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	@XmlAttribute(name="minuto")
	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	
}
