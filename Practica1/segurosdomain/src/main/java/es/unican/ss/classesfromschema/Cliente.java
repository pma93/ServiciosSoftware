//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.02.19 a las 12:46:30 PM CET 
//


package es.unican.ss.classesfromschema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Cliente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Cliente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.unican.es/ss/SegurosDomain}Email"/&gt;
 *         &lt;element name="seguro" type="{http://www.unican.es/ss/SegurosDomain}Seguro" maxOccurs="unbounded"/&gt;
 *         &lt;element name="parte" type="{http://www.unican.es/ss/SegurosDomain}Parte" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dni" type="{http://www.unican.es/ss/SegurosDomain}DNI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cliente", propOrder = {
    "nombre",
    "email",
    "seguro",
    "parte"
})
public class Cliente {

    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected List<Seguro> seguro;
    protected List<Parte> parte;
    @XmlAttribute(name = "dni")
    protected String dni;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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

    /**
     * Gets the value of the parte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parte }
     * 
     * 
     */
    public List<Parte> getParte() {
        if (parte == null) {
            parte = new ArrayList<Parte>();
        }
        return this.parte;
    }

    /**
     * Obtiene el valor de la propiedad dni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDni(String value) {
        this.dni = value;
    }

}
