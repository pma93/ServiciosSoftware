package es.unican.ss.segurosss;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class PWCBHandler implements CallbackHandler {
	@SuppressWarnings("deprecation")
	@Override
    public void handle(Callback[] arg0)
        throws IOException, UnsupportedCallbackException {
		
        for (int i = 0; i < arg0.length; i++) {
            WSPasswordCallback pwcb = (WSPasswordCallback)arg0[i];
            String id = pwcb.getIdentifier();
           
            if (pwcb.getUsage() == WSPasswordCallback.USERNAME_TOKEN_UNKNOWN) {
            	  // used when plain-text password in message
            	
            	System.out.println("USERNAME_TOKEN_UNKNOWN"); 
            	if (!"admin".equals(id) || !"admin".equals(pwcb.getPassword())) {
            		throw new UnsupportedCallbackException(arg0[i], "autentication failed");
            	}
            } else if (pwcb.getUsage() == WSPasswordCallback.USERNAME_TOKEN) {
            	System.out.println("USERNAME_TOKEN"); 
            	// for passwords sent in digest mode we need to provide the password,
				// because the original one can't be un-digested from the message           
            	 if (id.equals("admin")) {
            		 pwcb.setPassword("admin");
                } else {
                	throw new UnsupportedCallbackException(arg0[i], "autentication failed");
                }

            }
        }
    }

}
