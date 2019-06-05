
package es.unican.ss.ssgasolineras;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "MunicipioNoValido", targetNamespace = "http://SSGasolineras.ss.unican.es/")
public class MunicipioNoValido_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private MunicipioNoValido faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public MunicipioNoValido_Exception(String message, MunicipioNoValido faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public MunicipioNoValido_Exception(String message, MunicipioNoValido faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: es.unican.ss.ssgasolineras.MunicipioNoValido
     */
    public MunicipioNoValido getFaultInfo() {
        return faultInfo;
    }

}
