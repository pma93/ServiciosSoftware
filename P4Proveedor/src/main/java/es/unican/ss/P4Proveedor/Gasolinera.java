package es.unican.ss.P4Proveedor;

public class Gasolinera implements Comparable<Gasolinera>{
	
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
	
	public int compareTo(Gasolinera o) {
		int valor = 0;
		if(this.precio<o.precio) {
			valor =-1;
		}else if(this.precio>o.precio) {
			valor=1;
		}
		return valor;
	}
	
	@Override
	public String toString() {
		return "Informacion gasolinera" + " " + this.direccion + " " + this.localidad +
				" " + this.rotulo;
	}
}
