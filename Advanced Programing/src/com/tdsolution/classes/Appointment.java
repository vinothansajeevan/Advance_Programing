package com.tdsolution.classes;

import java.util.Date;

public class Appointment {
	private int id;
	private Date date;
	private Date time;
	private String status;
	private JobSeeker jobSeeker;
	private Consultant consultant;

	public Appointment(int id, Date date, Date time, String status, JobSeeker jobSeeker, Consultant consultant) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.status = status;
		this.jobSeeker = jobSeeker;
		this.consultant = consultant;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Date getTime() {
		return time;
	}

	public String getStatus() {
		return status;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public void confirm() {
		this.status = "Confirmed";
		// Logic to confirm the appointment
	}

	public void cancel() {
		this.status = "Cancelled";
		// Logic to cancel the appointment
	}

	// Add more methods as needed

	@Override
	public String toString() {
		return "Appointment{" + "id=" + id + ", date=" + date + ", time=" + time + ", status='" + status + '\'' + '}';
	}

	public void setId(int appointmentId) {
		// TODO Auto-generated method stub

	}
}
