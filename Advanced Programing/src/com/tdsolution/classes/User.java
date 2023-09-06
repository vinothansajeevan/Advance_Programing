package com.tdsolution.classes;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String email;
	private String phone;
	private List<Appointment> appointments;

	public User(int id, String name, String email, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.appointments = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void register() {
		// Logic to register the user
	}

	public boolean login() {
		// Logic to authenticate the user
		return false; // Replace with actual authentication logic
	}

	public void updateProfile(String newName, String newEmail, String newPhone) {
		// Logic to update the user's profile
		this.name = newName;
		this.email = newEmail;
		this.phone = newPhone;
	}

	public void scheduleAppointment(Appointment appointment) {
		// Logic to schedule an appointment
		appointments.add(appointment);
	}

	// Add more methods as needed

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\''
				+ '}';
	}
}

