package es.unican.ss.SSGasolineras;

public class MunicipioNoValido extends java.lang.Exception {
    private static final long serialVersionUID = 1520942361812L;
    private java.lang.String faultMessage;

    public MunicipioNoValido() {
        super("ErrorMsj");
    }

    public MunicipioNoValido(java.lang.String s) {
        super(s);
    }

    public MunicipioNoValido(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public MunicipioNoValido(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(java.lang.String msg) {
        faultMessage = msg;
    }

    public java.lang.String getFaultMessage() {
        return faultMessage;
    }
}
