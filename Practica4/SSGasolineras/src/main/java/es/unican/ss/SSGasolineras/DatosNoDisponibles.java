package es.unican.ss.SSGasolineras;

public class DatosNoDisponibles extends java.lang.Exception {
    private static final long serialVersionUID = 1520942361812L;
    private java.lang.String faultMessage;

    public DatosNoDisponibles() {
        super("No existen datos para el municipio introducido");
    }

    public DatosNoDisponibles(java.lang.String s) {
        super(s);
    }

    public DatosNoDisponibles(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public DatosNoDisponibles(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(java.lang.String msg) {
        faultMessage = msg;
    }

    public java.lang.String getFaultMessage() {
        return faultMessage;
    }
}
