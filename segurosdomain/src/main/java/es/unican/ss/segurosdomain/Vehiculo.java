package es.unican.ss.segurosdomain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(value=XmlAccessType.FIELD)
public class Vehiculo implements Serializable {

	@XmlAttribute(required=true)
	protected String matricula;
	
	@XmlElement(required=true)
	protected int potencia;
	
	@XmlElement(name="usoprofesional", required=true)
	protected boolean usoProfesional;

	public Vehiculo() { }
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public boolean getUsoProfesional() {
		return usoProfesional;
	}

	public void setUsoProfesional(boolean usoProfesional) {
		this.usoProfesional = usoProfesional;
	}
	
}
