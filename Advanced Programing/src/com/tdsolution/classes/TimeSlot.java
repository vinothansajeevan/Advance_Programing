package com.tdsolution.classes;

import java.util.Date;

public class TimeSlot {
	private Date startTime;
	private Date endTime;

	public TimeSlot(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	// Add methods to manipulate or check time slots as needed

	@Override
	public String toString() {
		return "TimeSlot{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
	}
}
