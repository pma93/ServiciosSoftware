package es.unican.ss.segurosdomain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(value=XmlAccessType.FIELD)
public class Seguro implements Serializable {

	private static final double FACTOR_POTENCIA = 1.5;
	private static final int PRECIO_USOPROFESIONAL = 100;
	private static final int PRECIO_BASE_TODORIESGO = 600;
	private static final int PRECIO_BASE_TERCEROS = 200;

	@XmlID
    @XmlAttribute(required=true)
	protected String id;
	
	@XmlElement(required=true)
	protected Vehiculo vehiculo;
	
	@XmlElement(name="tipo", required=true)
	protected TipoSeguro tipoSeguro;
	
	@XmlElement(required=true)
	protected double precio;

	public Seguro() {}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}
	
	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	
	public double getPrecio() {
		double precioBase = 0;
		double precioUsoProfesional = 0;
		double potencia = this.vehiculo.getPotencia();

		switch(this.getTipoSeguro()) {
			case TERCEROS:
				precioBase = PRECIO_BASE_TERCEROS;
				break;
			case TODO_RIESGO:
				precioBase = PRECIO_BASE_TODORIESGO;
				if(this.vehiculo.isUsoProfesional())
					precioUsoProfesional = PRECIO_USOPROFESIONAL;
				break;
			case TODO_RIESGO_FRANQUICIA:
				precioBase = PRECIO_BASE_TODORIESGO;
				break;
		}
		
		return (precioBase + precioUsoProfesional + (FACTOR_POTENCIA * potencia));
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
