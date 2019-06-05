package es.unican.ss.SSGasolineras;

import java.util.List;
import javax.jws.*;

@WebService
public interface GasolineraInterface {
	
	public List<Gasolinera> retornarListaGasolineras(String municipio) 
			throws DatosNoDisponibles, MunicipioNoValido;
	
	public Gasolinera retornarGasolineraPrecioMasBarato(String municipio) 
			throws DatosNoDisponibles, MunicipioNoValido;

}
