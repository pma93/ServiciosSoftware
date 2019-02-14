//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.02.12 a las 12:50:50 PM CET 
//


package newpackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cliente" type="{http://www.unican.es/ss/SegurosDomain}Cliente" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="seguro" type="{http://www.unican.es/ss/SegurosDomain}Seguro" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cliente",
    "seguro"
})
@XmlRootElement(name = "aseguradora")
public class Aseguradora {

    protected List<Cliente> cliente;
    protected List<Seguro> seguro;

    /**
     * Gets the value of the cliente property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cliente property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCliente().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cliente }
     * 
     * 
     */
    public List<Cliente> getCliente() {
        if (cliente == null) {
            cliente = new ArrayList<Cliente>();
        }
        return this.cliente;
    }

    /**
     * Gets the value of the seguro property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seguro property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeguro().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Seguro }
     * 
     * 
     */
    public List<Seguro> getSeguro() {
        if (seguro == null) {
            seguro = new ArrayList<Seguro>();
        }
        return this.seguro;
    }

}
