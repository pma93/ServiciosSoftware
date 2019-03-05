
package es.unican.ss.segurosdomain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SeguroTipo.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SeguroTipo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TERCEROS"/>
 *     &lt;enumeration value="TODO_RIESGO"/>
 *     &lt;enumeration value="TODO_RIESGO_FRANQUICIA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SeguroTipo")
@XmlEnum
public enum SeguroTipo {

    TERCEROS,
    TODO_RIESGO,
    TODO_RIESGO_FRANQUICIA;

    public String value() {
        return name();
    }

    public static SeguroTipo fromValue(String v) {
        return valueOf(v);
    }

}
