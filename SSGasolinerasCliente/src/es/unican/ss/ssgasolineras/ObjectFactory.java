
package es.unican.ss.ssgasolineras;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.unican.ss.ssgasolineras package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RetornarGasolineraPrecioMasBaratoResponse_QNAME = new QName("http://SSGasolineras.ss.unican.es/", "retornarGasolineraPrecioMasBaratoResponse");
    private final static QName _RetornarListaGasolinerasResponse_QNAME = new QName("http://SSGasolineras.ss.unican.es/", "retornarListaGasolinerasResponse");
    private final static QName _RetornarListaGasolineras_QNAME = new QName("http://SSGasolineras.ss.unican.es/", "retornarListaGasolineras");
    private final static QName _DatosNoDisponibles_QNAME = new QName("http://SSGasolineras.ss.unican.es/", "DatosNoDisponibles");
    private final static QName _MunicipioNoValido_QNAME = new QName("http://SSGasolineras.ss.unican.es/", "MunicipioNoValido");
    private final static QName _RetornarGasolineraPrecioMasBarato_QNAME = new QName("http://SSGasolineras.ss.unican.es/", "retornarGasolineraPrecioMasBarato");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.unican.ss.ssgasolineras
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetornarGasolineraPrecioMasBarato }
     * 
     */
    public RetornarGasolineraPrecioMasBarato createRetornarGasolineraPrecioMasBarato() {
        return new RetornarGasolineraPrecioMasBarato();
    }

    /**
     * Create an instance of {@link DatosNoDisponibles }
     * 
     */
    public DatosNoDisponibles createDatosNoDisponibles() {
        return new DatosNoDisponibles();
    }

    /**
     * Create an instance of {@link RetornarListaGasolineras }
     * 
     */
    public RetornarListaGasolineras createRetornarListaGasolineras() {
        return new RetornarListaGasolineras();
    }

    /**
     * Create an instance of {@link RetornarListaGasolinerasResponse }
     * 
     */
    public RetornarListaGasolinerasResponse createRetornarListaGasolinerasResponse() {
        return new RetornarListaGasolinerasResponse();
    }

    /**
     * Create an instance of {@link RetornarGasolineraPrecioMasBaratoResponse }
     * 
     */
    public RetornarGasolineraPrecioMasBaratoResponse createRetornarGasolineraPrecioMasBaratoResponse() {
        return new RetornarGasolineraPrecioMasBaratoResponse();
    }

    /**
     * Create an instance of {@link MunicipioNoValido }
     * 
     */
    public MunicipioNoValido createMunicipioNoValido() {
        return new MunicipioNoValido();
    }

    /**
     * Create an instance of {@link Gasolinera }
     * 
     */
    public Gasolinera createGasolinera() {
        return new Gasolinera();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetornarGasolineraPrecioMasBaratoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SSGasolineras.ss.unican.es/", name = "retornarGasolineraPrecioMasBaratoResponse")
    public JAXBElement<RetornarGasolineraPrecioMasBaratoResponse> createRetornarGasolineraPrecioMasBaratoResponse(RetornarGasolineraPrecioMasBaratoResponse value) {
        return new JAXBElement<RetornarGasolineraPrecioMasBaratoResponse>(_RetornarGasolineraPrecioMasBaratoResponse_QNAME, RetornarGasolineraPrecioMasBaratoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetornarListaGasolinerasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SSGasolineras.ss.unican.es/", name = "retornarListaGasolinerasResponse")
    public JAXBElement<RetornarListaGasolinerasResponse> createRetornarListaGasolinerasResponse(RetornarListaGasolinerasResponse value) {
        return new JAXBElement<RetornarListaGasolinerasResponse>(_RetornarListaGasolinerasResponse_QNAME, RetornarListaGasolinerasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetornarListaGasolineras }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SSGasolineras.ss.unican.es/", name = "retornarListaGasolineras")
    public JAXBElement<RetornarListaGasolineras> createRetornarListaGasolineras(RetornarListaGasolineras value) {
        return new JAXBElement<RetornarListaGasolineras>(_RetornarListaGasolineras_QNAME, RetornarListaGasolineras.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosNoDisponibles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SSGasolineras.ss.unican.es/", name = "DatosNoDisponibles")
    public JAXBElement<DatosNoDisponibles> createDatosNoDisponibles(DatosNoDisponibles value) {
        return new JAXBElement<DatosNoDisponibles>(_DatosNoDisponibles_QNAME, DatosNoDisponibles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MunicipioNoValido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SSGasolineras.ss.unican.es/", name = "MunicipioNoValido")
    public JAXBElement<MunicipioNoValido> createMunicipioNoValido(MunicipioNoValido value) {
        return new JAXBElement<MunicipioNoValido>(_MunicipioNoValido_QNAME, MunicipioNoValido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetornarGasolineraPrecioMasBarato }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SSGasolineras.ss.unican.es/", name = "retornarGasolineraPrecioMasBarato")
    public JAXBElement<RetornarGasolineraPrecioMasBarato> createRetornarGasolineraPrecioMasBarato(RetornarGasolineraPrecioMasBarato value) {
        return new JAXBElement<RetornarGasolineraPrecioMasBarato>(_RetornarGasolineraPrecioMasBarato_QNAME, RetornarGasolineraPrecioMasBarato.class, null, value);
    }

}
