package org.koushik.javabrains.messenger.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6328286661536343936L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
