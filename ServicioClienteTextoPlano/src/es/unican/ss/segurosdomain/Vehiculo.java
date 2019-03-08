
package es.unican.ss.segurosdomain;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Vehiculo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Vehiculo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="potencia" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="usoprofesional" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="matricula" type="{http://www.unican.es/ss/SegurosDomain}VehiculoMatricula" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehiculo", propOrder = {
    "potencia",
    "usoprofesional"
})
public class Vehiculo {

    @XmlElement(required = true)
    protected BigInteger potencia;
    protected boolean usoprofesional;
    @XmlAttribute(name = "matricula")
    protected String matricula;

    /**
     * Obtiene el valor de la propiedad potencia.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPotencia() {
        return potencia;
    }

    /**
     * Define el valor de la propiedad potencia.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPotencia(BigInteger value) {
        this.potencia = value;
    }

    /**
     * Obtiene el valor de la propiedad usoprofesional.
     * 
     */
    public boolean isUsoprofesional() {
        return usoprofesional;
    }

    /**
     * Define el valor de la propiedad usoprofesional.
     * 
     */
    public void setUsoprofesional(boolean value) {
        this.usoprofesional = value;
    }

    /**
     * Obtiene el valor de la propiedad matricula.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define el valor de la propiedad matricula.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricula(String value) {
        this.matricula = value;
    }

}
