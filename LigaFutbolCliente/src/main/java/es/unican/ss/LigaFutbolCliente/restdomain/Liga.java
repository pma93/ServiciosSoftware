package es.unican.ss.LigaFutbolCliente.restdomain;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="liga")
public class Liga {

	private List<Equipo> equipos;

	@XmlElement(name="equipo")
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
}
