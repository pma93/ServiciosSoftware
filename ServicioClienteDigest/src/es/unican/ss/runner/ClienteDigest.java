package es.unican.ss.runner;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.apache.rampart.RampartMessageData;

import es.unican.www.ss.segurosss.SegurosSSStub;

public class ClienteDigest {

	public static void main(String[] args) {
		try {
			SegurosSSStub stub = new SegurosSSStub("http://localhost:8081/axis2/services/SegurosSS");
			
	         // configure and engage Rampart
	         ServiceClient client = stub._getServiceClient();
	          
	         Options options = client.getOptions();
	         options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
	             loadPolicy("policy.xml"));
	         //Invocacion con credenciales no validas
	         options.setUserName("admin1");
	         options.setPassword("admin1");
	        client.engageModule("rampart");
	         
	         System.out.println(stub.retornarDatosSeguro("DEF-123456"));
	         
	      } catch (AxisFault e) {
	    	  System.out.println(e.getMessage());

	      } catch (Exception e) {
	        e.printStackTrace();
	      }

	}
	/**
     * Load policy file from classpath.
     */
    @SuppressWarnings("deprecation")
	private static Policy loadPolicy(String name) throws XMLStreamException {
    	
        StAXOMBuilder builder = null;
		try {
			builder = new StAXOMBuilder(name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        return PolicyEngine.getPolicy(builder.getDocumentElement());
    }

}
