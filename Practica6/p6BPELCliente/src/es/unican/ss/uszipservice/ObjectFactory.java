
package es.unican.ss.uszipservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.unican.ss.uszipservice package. 
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

    private final static QName _ZipCodesByCity_QNAME = new QName("http://www.unican.es/ss/USZipService", "zipCodesByCity");
    private final static QName _ZipCodesByCityResponse_QNAME = new QName("http://www.unican.es/ss/USZipService", "zipCodesByCityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.unican.ss.uszipservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZipCodesByCity }
     * 
     */
    public ZipCodesByCity createZipCodesByCity() {
        return new ZipCodesByCity();
    }

    /**
     * Create an instance of {@link ZipCodesByCityResponse }
     * 
     */
    public ZipCodesByCityResponse createZipCodesByCityResponse() {
        return new ZipCodesByCityResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZipCodesByCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unican.es/ss/USZipService", name = "zipCodesByCity")
    public JAXBElement<ZipCodesByCity> createZipCodesByCity(ZipCodesByCity value) {
        return new JAXBElement<ZipCodesByCity>(_ZipCodesByCity_QNAME, ZipCodesByCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZipCodesByCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.unican.es/ss/USZipService", name = "zipCodesByCityResponse")
    public JAXBElement<ZipCodesByCityResponse> createZipCodesByCityResponse(ZipCodesByCityResponse value) {
        return new JAXBElement<ZipCodesByCityResponse>(_ZipCodesByCityResponse_QNAME, ZipCodesByCityResponse.class, null, value);
    }

}
