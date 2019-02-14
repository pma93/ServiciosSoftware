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
	private Date fecha;
	
	@XmlIDREF
	@XmlElement(required=true)
	private Seguro Seguro;
	
	public Parte() {}
	
	public double getImporte() {
		return importe;
	}
	
	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Seguro getSeguro() {
		return Seguro;
	}

	public void setSeguro(Seguro seguro) {
		Seguro = seguro;
	}

}
