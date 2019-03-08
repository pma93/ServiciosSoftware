
package es.unican.ss.segurosss.types;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import es.unican.ss.segurosdomain.SeguroTipo;


/**
 * <p>Clase Java para InfoSeguro complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InfoSeguro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoSeguro" type="{http://www.unican.es/ss/SegurosDomain}SeguroTipo"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="matricula" type="{http://www.unican.es/ss/SegurosDomain}VehiculoMatricula"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoSeguro", propOrder = {
    "tipoSeguro",
    "precio",
    "matricula"
})
public class InfoSeguro {

    @XmlElement(required = true)
    protected SeguroTipo tipoSeguro;
    @XmlElement(required = true)
    protected BigDecimal precio;
    @XmlElement(required = true)
    protected String matricula;

    /**
     * Obtiene el valor de la propiedad tipoSeguro.
     * 
     * @return
     *     possible object is
     *     {@link SeguroTipo }
     *     
     */
    public SeguroTipo getTipoSeguro() {
        return tipoSeguro;
    }

    /**
     * Define el valor de la propiedad tipoSeguro.
     * 
     * @param value
     *     allowed object is
     *     {@link SeguroTipo }
     *     
     */
    public void setTipoSeguro(SeguroTipo value) {
        this.tipoSeguro = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecio(BigDecimal value) {
        this.precio = value;
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
