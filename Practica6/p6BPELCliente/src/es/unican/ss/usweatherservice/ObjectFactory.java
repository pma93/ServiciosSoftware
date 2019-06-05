
package es.unican.ss.usweatherservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.unican.ss.usweatherservice package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.unican.ss.usweatherservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHumidityRequest }
     * 
     */
    public GetHumidityRequest createGetHumidityRequest() {
        return new GetHumidityRequest();
    }

    /**
     * Create an instance of {@link GetTemperatureResponse }
     * 
     */
    public GetTemperatureResponse createGetTemperatureResponse() {
        return new GetTemperatureResponse();
    }

    /**
     * Create an instance of {@link GetTemperatureRequest }
     * 
     */
    public GetTemperatureRequest createGetTemperatureRequest() {
        return new GetTemperatureRequest();
    }

    /**
     * Create an instance of {@link GetHumidityResponse }
     * 
     */
    public GetHumidityResponse createGetHumidityResponse() {
        return new GetHumidityResponse();
    }

}
