
package es.unican.ss.ssgasolineras;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para retornarGasolineraPrecioMasBaratoResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="retornarGasolineraPrecioMasBaratoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://SSGasolineras.ss.unican.es/}gasolinera" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retornarGasolineraPrecioMasBaratoResponse", propOrder = {
    "_return"
})
public class RetornarGasolineraPrecioMasBaratoResponse {

    @XmlElement(name = "return")
    protected Gasolinera _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link Gasolinera }
     *     
     */
    public Gasolinera getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link Gasolinera }
     *     
     */
    public void setReturn(Gasolinera value) {
        this._return = value;
    }

}
