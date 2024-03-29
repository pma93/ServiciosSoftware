
package es.unican.ss.segurosdomain;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.unican.ss.segurosdomain package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.unican.ss.segurosdomain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Aseguradora }
     * 
     */
    public Aseguradora createAseguradora() {
        return new Aseguradora();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link Parte }
     * 
     */
    public Parte createParte() {
        return new Parte();
    }

    /**
     * Create an instance of {@link Vehiculo }
     * 
     */
    public Vehiculo createVehiculo() {
        return new Vehiculo();
    }

    /**
     * Create an instance of {@link Seguro }
     * 
     */
    public Seguro createSeguro() {
        return new Seguro();
    }

}
