/**
 * DatosNoValidosException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package es.unican.ss.segurosss;

import es.unican.ss.segurosss.types.DatosNoValidos;

public class DatosNoValidosException extends java.lang.Exception {
    private static final long serialVersionUID = 1551655792080L;
    private DatosNoValidos faultMessage;

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

    public void setFaultMessage(DatosNoValidos d) {
        faultMessage = d;
    }

    public DatosNoValidos getFaultMessage() {
        return faultMessage;
    }
}
