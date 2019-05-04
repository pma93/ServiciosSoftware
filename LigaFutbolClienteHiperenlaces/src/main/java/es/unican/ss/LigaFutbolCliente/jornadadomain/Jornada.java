package es.unican.ss.LigaFutbolCliente.jornadadomain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jornada")
public class Jornada {

	private List<Partido> partidos;
	private int numero;
	
	public Jornada() {
		partidos = 	new ArrayList<Partido>();
	}

	@XmlElement(name="partido")
	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	@XmlAttribute(name="num")
	public int getNum() {
		return numero;
	}

	public void setNum(int numero) {
		this.numero = numero;
	}
	
}
