package es.unican.ss.LigaFutbolHiperenlaces.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="clasificacion")
public class ListaEquipos {

	private List<Equipo> equipos;
	
	public ListaEquipos() {}
	
	public ListaEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	public List<Equipo> getEquipos(){
		return this.equipos;
	}
	
	public void setEquipos(List<Equipo> equipos){
		this.equipos = equipos;
	}
	
}
