package com.tdsolution.classes;

import java.util.ArrayList;
import java.util.List;

public class JobSeeker extends User {
	private int jobSeekerId;
	private String jobSeekerInfo;
	private List<Appointment> appointments;

	public JobSeeker(int id, String name, String email, String phone, int jobSeekerId, String jobSeekerInfo) {
		super(id, name, email, phone);
		this.jobSeekerId = jobSeekerId;
		this.jobSeekerInfo = jobSeekerInfo;
		this.appointments = new ArrayList<>();
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public String getJobSeekerInfo() {
		return jobSeekerInfo;
	}

	@Override
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void applyForJob() {
		// Logic to apply for a job
	}

	// Add more methods as needed

	@Override
	public String toString() {
		return "JobSeeker{" + "jobSeekerId=" + jobSeekerId + ", jobSeekerInfo='" + jobSeekerInfo + '\'' + '}';
	}

	public void setId(int jobSeekerId2) {
		// TODO Auto-generated method stub

	}
}
