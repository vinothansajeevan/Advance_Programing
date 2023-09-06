package com.tdsolution.classes;

public class Report {
	private int reportId;
	private String reportType;
	private String content;

	public Report(int reportId, String reportType, String content) {
		this.reportId = reportId;
		this.reportType = reportType;
		this.content = content;
	}

	public int getReportId() {
		return reportId;
	}

	public String getReportType() {
		return reportType;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Report{" + "reportId=" + reportId + ", reportType='" + reportType + '\'' + ", content='" + content
				+ '\'' + '}';
	}

	public void setReportId(int reportId2) {
		// TODO Auto-generated method stub

	}
}
