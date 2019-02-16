package es.unican.ss.segurosdomain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(value=XmlAccessType.FIELD)
public class Parte implements Serializable {
	
	@XmlElement(required=true)
	private double importe;
	
	@XmlElement(required=true)
	private String fecha;
	
	@XmlIDREF
	@XmlElement(name = "seguroref", required=true)
	private Seguro seguro;
	
	public Parte() {}
	
	public double getImporte() {
		return importe;
	}
	
	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

}
