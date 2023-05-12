package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	
//... imports class definition...
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents;
    
    
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		securityIncidents = new ArrayList<String>();
	}
    
    public boolean assignPin(int pin) {
    	Integer p = (Integer)pin;
		String code = p.toString();
		if (code.length() == 6) {
			this.setPin(pin);
			return true;
		}
		else {
			return false;
		}
    }
    public boolean accessAuthorized(Integer id) {
		if (this.getId().equals(id)) {
			return true;
		}
		else {
			this.authIncident();
			return false;
		}
	}
    public ArrayList<String> reportSecurityIncidents() {
    	return getSecurityIncidents();
    }
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    
    // TO DO: Setters & Getters
    
}
