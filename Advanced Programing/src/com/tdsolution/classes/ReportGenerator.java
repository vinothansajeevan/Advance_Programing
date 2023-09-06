package com.tdsolution.classes;

import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
	private List<Report> reports;

	private static ReportGenerator instance;

	private ReportGenerator() {
		reports = new ArrayList<>();
	}

	public static ReportGenerator getInstance() {
		if (instance == null) {
			instance = new ReportGenerator();
		}
		return instance;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void addReport(Report report) {
		reports.add(report);
	}

	public void generateAppointmentReport() {
		// Logic to generate appointment report
	}

	public void generateConsultantPerformanceReport() {
		// Logic to generate consultant performance report
	}

	// Add more report generation methods as needed

	@Override
	public String toString() {
		return "ReportGenerator{" + "reports=" + reports + '}';
	}
}
