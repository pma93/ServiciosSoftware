
package es.unican.ss.segurosss.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.unican.ss.segurosss.types package. 
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

    private final static QName _RetornarListaSeguros_QNAME = new QName("http://www.unican.es/ss/SegurosSS/types/", "RetornarListaSeguros");
    private final static QName _DatosNoValidos_QNAME = new QName("http://www.unican.es/ss/SegurosSS/types/", "DatosNoValidos");
    private final static QName _RetornarDatosSeguroResponse_QNAME = new QName("http://www.unican.es/ss/SegurosSS/types/", "RetornarDatosSeguroResponse");
    private final static QName _RetornarListaSegurosResponse_QNAME = new QName("http://www.unican.es/ss/SegurosSS/types/", "RetornarListaSegurosResponse");
    private final static QName _RetornarDatosSeguro_QNAME = new QName("http://www.unican.es/ss/SegurosSS/types/", "RetornarDatosSeguro");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.unican.ss.segurosss.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DatosNoValidos }
     * 
     */
    public DatosNoValidos createDatosNoValidos() {
        return new DatosNoValidos();
    }

    /**
     * Create an instance of {@link InfoSeguro }
     * 
     */
    public InfoSeguro createInfoSeguro() {
        return new InfoSeguro();
    }

    /**
     * Create an instance of {@link ListaSeguros }
     * 
     */
    public ListaSeguros createListaSeguros() {
        return new ListaSeguros();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unican.es/ss/SegurosSS/types/", name = "RetornarListaSeguros")
    public JAXBElement<String> createRetornarListaSeguros(String value) {
        return new JAXBElement<String>(_RetornarListaSeguros_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosNoValidos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unican.es/ss/SegurosSS/types/", name = "DatosNoValidos")
    public JAXBElement<DatosNoValidos> createDatosNoValidos(DatosNoValidos value) {
        return new JAXBElement<DatosNoValidos>(_DatosNoValidos_QNAME, DatosNoValidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoSeguro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unican.es/ss/SegurosSS/types/", name = "RetornarDatosSeguroResponse")
    public JAXBElement<InfoSeguro> createRetornarDatosSeguroResponse(InfoSeguro value) {
        return new JAXBElement<InfoSeguro>(_RetornarDatosSeguroResponse_QNAME, InfoSeguro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaSeguros }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unican.es/ss/SegurosSS/types/", name = "RetornarListaSegurosResponse")
    public JAXBElement<ListaSeguros> createRetornarListaSegurosResponse(ListaSeguros value) {
        return new JAXBElement<ListaSeguros>(_RetornarListaSegurosResponse_QNAME, ListaSeguros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unican.es/ss/SegurosSS/types/", name = "RetornarDatosSeguro")
    public JAXBElement<String> createRetornarDatosSeguro(String value) {
        return new JAXBElement<String>(_RetornarDatosSeguro_QNAME, String.class, null, value);
    }

}
