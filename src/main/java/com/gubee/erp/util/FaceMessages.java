package com.gubee.erp.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FaceMessages implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private void  add(String msg, FacesMessage.Severity severity) {
		FacesMessage facemessage = new FacesMessage(msg);
		facemessage.setSeverity(severity);
		
		
		FacesContext.getCurrentInstance().addMessage(null, facemessage);
		
	}
	public void info(String msg) {
		add(msg, FacesMessage.SEVERITY_INFO);
	}
	
}
