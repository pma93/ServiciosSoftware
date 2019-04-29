package es.unican.ss.LigaFutbolCliente.jornadadomain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="partido")
public class Partido {
	
	private EquipoLocal equipoLocal;
	private EquipoVisitante equipoVisitante;
	
	@XmlElement(name="equipoLocal")
	public EquipoLocal getEquipoLocal() {
		return equipoLocal;
	}
	
	public void setEquipoLocal(EquipoLocal equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	
	@XmlElement(name="equipoVisitante")
	public EquipoVisitante getEquipoVisitante() {
		return equipoVisitante;
	}
	
	public void setEquipoVisitante(EquipoVisitante equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

}
