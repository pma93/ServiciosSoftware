package es.unican.ss.SSGasolineras;

/**
 * Main
 * 
 * PRUEBA LOCAL TEMPORAL, ELIMINAR DE CARA A LA ENTREGA.
 * Puede servir esta implementación como base para el cliente
*/
public class Main {

	public static void main(String[] args) {
		try {
			Gasolineras gasolineras = new Gasolineras();
			System.out.println("Demo arrancada...");

			try {
				System.out.println(gasolineras.retornarListaGasolineras("Medio Cudeyo"));
			} catch (DatosNoDisponibles e) {
				System.out.println("DatosNoDisponibles: Se ha producido un error");
			} catch (MunicipioNoValido e) {
				System.out.println("MunicipioNoValido: Se ha producido un error");
			}
			
			try {
				System.out.println(gasolineras.retornarGasolineraPrecioMasBarato("Medio Cudeyo"));
			} catch (DatosNoDisponibles e) {
				System.out.println("DatosNoDisponibles: Se ha producido un error");
			} catch (MunicipioNoValido e) {
				System.out.println("MunicipioNoValido: Se ha producido un error");
			}
			
			try {
				System.out.println(gasolineras.retornarListaGasolineras("MunicipioInventado"));
			} catch (DatosNoDisponibles e) {
				System.out.println("DatosNoDisponibles: Se ha producido un error");
			} catch (MunicipioNoValido e) {
				System.out.println("MunicipioNoValido: Se ha producido un error");
			}
			
			try {
				System.out.println(gasolineras.retornarGasolineraPrecioMasBarato("MunicipioInventado"));
			} catch (DatosNoDisponibles e) {
				System.out.println("DatosNoDisponibles: Se ha producido un error");
			} catch (MunicipioNoValido e) {
				System.out.println("MunicipioNoValido: Se ha producido un error");
			}

		}catch (Exception e) {
			System.out.println("Exception: Se ha producido un error");
			e.printStackTrace();
		}
	}
}
