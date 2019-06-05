package es.unican.ss.segurosdomain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(value=XmlAccessType.FIELD)
public class Cliente implements Serializable {

	@XmlAttribute(required=true)
	protected String dni;
	
	@XmlElement(required=true)
	protected String nombre;
	
	@XmlElement(required=true)
	protected String email;
	
	@XmlElement(name="seguro", required=true)
	protected List<Seguro> seguros;
	
	@XmlElement(name="parte", required=true)
	protected List<Parte> partes;
	
	public Cliente() {
		seguros = new LinkedList<Seguro>();
		partes = new LinkedList<Parte>();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
	
	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}
}
