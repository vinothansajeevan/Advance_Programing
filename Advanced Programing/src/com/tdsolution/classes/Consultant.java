package com.tdsolution.classes;

import java.util.ArrayList;
import java.util.List;

public class Consultant extends User {
	private String expertise;
	private List<TimeSlot> availability;

	public Consultant(int id, String name, String email, String phone, String expertise) {
		super(id, name, email, phone);
		this.expertise = expertise;
		this.availability = new ArrayList<>();
	}

	public String getExpertise() {
		return expertise;
	}

	public List<TimeSlot> getAvailability() {
		return availability;
	}

	public void setAvailability(List<TimeSlot> availability) {
		this.availability = availability;
	}

	public void viewSchedule() {
		// Logic to display the consultant's schedule
	}

	// Add more methods as needed

	@Override
	public String toString() {
		return "Consultant{" + "id=" + getId() + ", name='" + getName() + '\'' + ", email='" + getEmail() + '\''
				+ ", phone='" + getPhone() + '\'' + ", expertise='" + expertise + '\'' + '}';
	}

	public void setId(int consultantId) {
		// TODO Auto-generated method stub

	}
}
