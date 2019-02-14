//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.02.12 a las 12:50:50 PM CET 
//


package newpackage;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Parte complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Parte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="importe" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="seguro" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.unican.es/ss/SegurosDomain}SeguroID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parte", propOrder = {
    "importe",
    "fecha",
    "seguro"
})
public class Parte {

    @XmlElement(required = true)
    protected BigDecimal importe;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecha;
    @XmlElement(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object seguro;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Obtiene el valor de la propiedad importe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImporte() {
        return importe;
    }

    /**
     * Define el valor de la propiedad importe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImporte(BigDecimal value) {
        this.importe = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad seguro.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSeguro() {
        return seguro;
    }

    /**
     * Define el valor de la propiedad seguro.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSeguro(Object value) {
        this.seguro = value;
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
