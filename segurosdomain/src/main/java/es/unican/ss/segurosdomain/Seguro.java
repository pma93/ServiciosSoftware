package es.unican.ss.segurosdomain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(value=XmlAccessType.FIELD)
public class Seguro implements Serializable {

	// Factor multiplicador aplicable al valor de potencia
	private static final double FACTOR_POTENCIA = 1.5;
	
	// Precios fijos en euros de los distintos conceptos aplicables
	private static final double PRECIO_USOPROFESIONAL = 100;
	private static final double PRECIO_BASE_TODORIESGO = 600;
	private static final double PRECIO_BASE_TERCEROS = 200;

	@XmlID
    @XmlAttribute(required=true)
	protected String id;
	
	@XmlElement(required=true)
	protected Vehiculo vehiculo;
	
	@XmlElement(name="tipo", required=true)
	protected TipoSeguro tipoSeguro;

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
	
	public double calculaPrecio() {
		double precioBase = 0;
		double precioUsoProfesional = 0;
		double potencia = this.vehiculo.getPotencia();

		switch(this.getTipoSeguro()) {
			case TERCEROS:
				precioBase = PRECIO_BASE_TERCEROS;
				break;
			case TODO_RIESGO:
				precioBase = PRECIO_BASE_TODORIESGO;
				if(this.vehiculo.getUsoProfesional())
					precioUsoProfesional = PRECIO_USOPROFESIONAL;
				break;
			case TODO_RIESGO_FRANQUICIA:
				precioBase = PRECIO_BASE_TODORIESGO;
				break;
		}
		
		return (precioBase + precioUsoProfesional + (FACTOR_POTENCIA * potencia));
	}
}
