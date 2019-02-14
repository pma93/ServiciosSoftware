//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.02.12 a las 12:50:50 PM CET 
//


package newpackage;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
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
 *     &lt;enumeration value="TODO RIESGO"/>
 *     &lt;enumeration value="TODO RIESGO CON FRANQUICIA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SeguroTipo")
@XmlEnum
public enum SeguroTipo {

    TERCEROS("TERCEROS"),
    @XmlEnumValue("TODO RIESGO")
    TODO_RIESGO("TODO RIESGO"),
    @XmlEnumValue("TODO RIESGO CON FRANQUICIA")
    TODO_RIESGO_CON_FRANQUICIA("TODO RIESGO CON FRANQUICIA");
    private final String value;

    SeguroTipo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SeguroTipo fromValue(String v) {
        for (SeguroTipo c: SeguroTipo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
