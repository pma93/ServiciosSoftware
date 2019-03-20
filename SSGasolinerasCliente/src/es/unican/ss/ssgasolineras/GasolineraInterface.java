
package es.unican.ss.ssgasolineras;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GasolineraInterface", targetNamespace = "http://SSGasolineras.ss.unican.es/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GasolineraInterface {


    /**
     * 
     * @param arg0
     * @return
     *     returns es.unican.ss.ssgasolineras.Gasolinera
     * @throws MunicipioNoValido_Exception
     * @throws DatosNoDisponibles_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retornarGasolineraPrecioMasBarato", targetNamespace = "http://SSGasolineras.ss.unican.es/", className = "es.unican.ss.ssgasolineras.RetornarGasolineraPrecioMasBarato")
    @ResponseWrapper(localName = "retornarGasolineraPrecioMasBaratoResponse", targetNamespace = "http://SSGasolineras.ss.unican.es/", className = "es.unican.ss.ssgasolineras.RetornarGasolineraPrecioMasBaratoResponse")
    @Action(input = "http://SSGasolineras.ss.unican.es/GasolineraInterface/retornarGasolineraPrecioMasBaratoRequest", output = "http://SSGasolineras.ss.unican.es/GasolineraInterface/retornarGasolineraPrecioMasBaratoResponse", fault = {
        @FaultAction(className = DatosNoDisponibles_Exception.class, value = "http://SSGasolineras.ss.unican.es/GasolineraInterface/retornarGasolineraPrecioMasBarato/Fault/DatosNoDisponibles"),
        @FaultAction(className = MunicipioNoValido_Exception.class, value = "http://SSGasolineras.ss.unican.es/GasolineraInterface/retornarGasolineraPrecioMasBarato/Fault/MunicipioNoValido")
    })
    public Gasolinera retornarGasolineraPrecioMasBarato(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws DatosNoDisponibles_Exception, MunicipioNoValido_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<es.unican.ss.ssgasolineras.Gasolinera>
     * @throws MunicipioNoValido_Exception
     * @throws DatosNoDisponibles_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retornarListaGasolineras", targetNamespace = "http://SSGasolineras.ss.unican.es/", className = "es.unican.ss.ssgasolineras.RetornarListaGasolineras")
    @ResponseWrapper(localName = "retornarListaGasolinerasResponse", targetNamespace = "http://SSGasolineras.ss.unican.es/", className = "es.unican.ss.ssgasolineras.RetornarListaGasolinerasResponse")
    @Action(input = "http://SSGasolineras.ss.unican.es/GasolineraInterface/retornarListaGasolinerasRequest", output = "http://SSGasolineras.ss.unican.es/GasolineraInterface/retornarListaGasolinerasResponse", fault = {
        @FaultAction(className = DatosNoDisponibles_Exception.class, value = "http://SSGasolineras.ss.unican.es/GasolineraInterface/retornarListaGasolineras/Fault/DatosNoDisponibles"),
        @FaultAction(className = MunicipioNoValido_Exception.class, value = "http://SSGasolineras.ss.unican.es/GasolineraInterface/retornarListaGasolineras/Fault/MunicipioNoValido")
    })
    public List<Gasolinera> retornarListaGasolineras(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws DatosNoDisponibles_Exception, MunicipioNoValido_Exception
    ;

}