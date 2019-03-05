
package es.unican.ss.segurosss.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import es.unican.ss.segurosdomain.Seguro;


/**
 * <p>Clase Java para ListaSeguros complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ListaSeguros">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SeguroCliente" type="{http://www.unican.es/ss/SegurosDomain}Seguro" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaSeguros", propOrder = {
    "seguroCliente"
})
public class ListaSeguros {

    @XmlElement(name = "SeguroCliente")
    protected List<Seguro> seguroCliente;

    /**
     * Gets the value of the seguroCliente property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seguroCliente property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeguroCliente().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Seguro }
     * 
     * 
     */
    public List<Seguro> getSeguroCliente() {
        if (seguroCliente == null) {
            seguroCliente = new ArrayList<Seguro>();
        }
        return this.seguroCliente;
    }

}
