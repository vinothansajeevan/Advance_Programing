package com.tdsolution.classes;

import java.util.ArrayList;
import java.util.List;

public class AppointmentScheduler {
	private List<Appointment> appointments;

	public AppointmentScheduler() {
		this.appointments = new ArrayList<>();
	}

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public List<Appointment> getAppointmentsForConsultant(Consultant consultant) {
		List<Appointment> consultantAppointments = new ArrayList<>();
		for (Appointment appointment : appointments) {
			if (appointment.getConsultant().equals(consultant)) {
				consultantAppointments.add(appointment);
			}
		}
		return consultantAppointments;
	}

	public List<Appointment> getAppointmentsForJobSeeker(JobSeeker jobSeeker) {
		List<Appointment> jobSeekerAppointments = new ArrayList<>();
		for (Appointment appointment : appointments) {
			if (appointment.getJobSeeker().equals(jobSeeker)) {
				jobSeekerAppointments.add(appointment);
			}
		}
		return jobSeekerAppointments;
	}

	// Other methods for updating and managing appointments can be added here.
}
