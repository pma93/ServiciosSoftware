
package es.unican.ss.segurosdomain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Clase Java para Seguro complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Seguro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo" type="{http://www.unican.es/ss/SegurosDomain}SeguroTipo"/>
 *         &lt;element name="vehiculo" type="{http://www.unican.es/ss/SegurosDomain}Vehiculo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Seguro", propOrder = {
    "tipo",
    "vehiculo"
})
public class Seguro {

    @XmlElement(required = true)
    protected SeguroTipo tipo;
    @XmlElement(required = true)
    protected Vehiculo vehiculo;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link SeguroTipo }
     *     
     */
    public SeguroTipo getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link SeguroTipo }
     *     
     */
    public void setTipo(SeguroTipo value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad vehiculo.
     * 
     * @return
     *     possible object is
     *     {@link Vehiculo }
     *     
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Define el valor de la propiedad vehiculo.
     * 
     * @param value
     *     allowed object is
     *     {@link Vehiculo }
     *     
     */
    public void setVehiculo(Vehiculo value) {
        this.vehiculo = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
