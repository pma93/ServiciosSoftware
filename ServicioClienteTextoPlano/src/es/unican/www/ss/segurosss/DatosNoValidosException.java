/**
 * DatosNoValidosException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package es.unican.www.ss.segurosss;

public class DatosNoValidosException extends java.lang.Exception {
    private static final long serialVersionUID = 1552049293491L;
    private es.unican.ss.segurosss.types.DatosNoValidos faultMessage;

    public DatosNoValidosException() {
        super("DatosNoValidosException");
    }

    public DatosNoValidosException(java.lang.String s) {
        super(s);
    }

    public DatosNoValidosException(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public DatosNoValidosException(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(es.unican.ss.segurosss.types.DatosNoValidos msg) {
        faultMessage = msg;
    }

    public es.unican.ss.segurosss.types.DatosNoValidos getFaultMessage() {
        return faultMessage;
    }
}
