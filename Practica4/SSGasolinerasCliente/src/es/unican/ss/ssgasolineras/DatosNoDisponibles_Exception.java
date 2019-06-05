
package es.unican.ss.ssgasolineras;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DatosNoDisponibles", targetNamespace = "http://SSGasolineras.ss.unican.es/")
public class DatosNoDisponibles_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DatosNoDisponibles faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DatosNoDisponibles_Exception(String message, DatosNoDisponibles faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DatosNoDisponibles_Exception(String message, DatosNoDisponibles faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: es.unican.ss.ssgasolineras.DatosNoDisponibles
     */
    public DatosNoDisponibles getFaultInfo() {
        return faultInfo;
    }

}
