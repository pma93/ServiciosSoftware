package es.unican.ss.P4Proveedor;

import java.util.List;
import javax.jws.*;

@WebService
public interface GasolineraInterface {
	
	public Gasolinera retornarGasolineraPrecioMasBarato(String municipio) 
			throws DatosNoDisponibles, MunicipioNoValido;
	
	public List<Gasolinera> retornarListaGasolineras(String municipio) 
			throws DatosNoDisponibles, MunicipioNoValido;

}
