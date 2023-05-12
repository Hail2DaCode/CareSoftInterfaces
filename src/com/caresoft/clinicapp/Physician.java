package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;


public class Physician extends User implements HIPAACompliantUser {
	public Physician(int ID) {
		super(ID);
	}
	public boolean assignPin(int pin) {
		Integer p = (Integer)pin;
		String code = p.toString();
		if (code.length() == 4) {
			this.setPin(pin);
			return true;
		}
		else {
			return false;
		}
		
	}
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	public boolean accessAuthorized(Integer id) {
		if (this.getId().equals(id)) {
			return true;
		}
		else {
			return false;
		}
	}
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters

}
