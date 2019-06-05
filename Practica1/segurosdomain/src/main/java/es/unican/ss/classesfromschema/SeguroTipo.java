//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.02.19 a las 12:46:30 PM CET 
//


package es.unican.ss.classesfromschema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SeguroTipo.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SeguroTipo"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TERCEROS"/&gt;
 *     &lt;enumeration value="TODO_RIESGO"/&gt;
 *     &lt;enumeration value="TODO_RIESGO_FRANQUICIA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
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
