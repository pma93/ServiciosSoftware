package es.unican.ss.SSGasolineras;

/**
 * Gasolinera
 * 
 * Representación de una estación.
*/
public class Gasolinera implements Comparable<Gasolinera> {
	
	private String direccion;
	private String localidad;
	private String rotulo;
	private double precio;
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getRotulo() {
		return rotulo;
	}
	
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int compareTo(Gasolinera gasolinera) {
		if(this.precio < gasolinera.precio) {
			return -1;
		}else if(this.precio > gasolinera.precio) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "======\nInformacion gasolinera:\n" 
				+ "Dirección: " + this.direccion 
				+ "\nLocalidad: " + this.localidad 
				+ "\nRótulo: " + this.rotulo 
				+ "\nPrecio: " + this.precio 
				+ "\n======";
	}

}
