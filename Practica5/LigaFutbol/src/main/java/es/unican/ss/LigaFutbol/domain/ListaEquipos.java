package es.unican.ss.LigaFutbol.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="equipos")
public class ListaEquipos {

	private List<Equipo> equipos;
	
	public ListaEquipos() {}
	
	public ListaEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	@XmlElement(name="equipo")
	public List<Equipo> getEquipos(){
		return this.equipos;
	}
	
	public void setEquipos(List<Equipo> equipos){
		this.equipos = equipos;
	}
	
}
