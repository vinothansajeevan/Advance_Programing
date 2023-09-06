package com.tdsolution.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DatabaseManager {
	private Connection connection;

	public DatabaseManager() {
		// Initialize the database connection in the constructor
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/onlineappointment";
			String username = "root";
			String password = "msigf638";
			connection = DriverManager.getConnection(jdbcUrl, username, password);
		} catch (SQLException e) {
			handleDatabaseConnectionError(e);
		}
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			handleDatabaseConnectionError(e);
		}
	}

	// User-related database operations
	public void addUser(User user) {
		String sql = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
	}

	public User getUserById(int userId) {
		String sql = "SELECT * FROM users WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				return new User(id, name, email, phone);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
		return null;
	}

	// Consultant-related database operations
	public void addConsultant(Consultant consultant) {
		String sql = "INSERT INTO consultants (name, email, phone, expertise) VALUES (?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, consultant.getName());
			preparedStatement.setString(2, consultant.getEmail());
			preparedStatement.setString(3, consultant.getPhone());
			preparedStatement.setString(4, consultant.getExpertise());
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				int consultantId = generatedKeys.getInt(1);
				consultant.setId(consultantId);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
	}

	public Consultant getConsultantById(int consultantId) {
		String sql = "SELECT * FROM consultants WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, consultantId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String expertise = resultSet.getString("expertise");
				return new Consultant(id, name, email, phone, expertise);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
		return null;
	}

	// JobSeeker-related database operations
	public void addJobSeeker(JobSeeker jobSeeker) {
		String sql = "INSERT INTO job_seekers (name, email, phone, job_seeker_id, job_seeker_info) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, jobSeeker.getName());
			preparedStatement.setString(2, jobSeeker.getEmail());
			preparedStatement.setString(3, jobSeeker.getPhone());
			preparedStatement.setInt(4, jobSeeker.getJobSeekerId());
			preparedStatement.setString(5, jobSeeker.getJobSeekerInfo());
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				int jobSeekerId = generatedKeys.getInt(1);
				jobSeeker.setId(jobSeekerId);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
	}

	public JobSeeker getJobSeekerById(int jobSeekerId) {
		String sql = "SELECT * FROM job_seekers WHERE job_seeker_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, jobSeekerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String jobSeekerInfo = resultSet.getString("job_seeker_info");
				return new JobSeeker(id, name, email, phone, jobSeekerId, jobSeekerInfo);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
		return null;
	}

	// Appointment-related database operations
	public void addAppointment(Appointment appointment) {
		String sql = "INSERT INTO appointments (date, time, status, job_seeker_id, consultant_id) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setDate(1, new java.sql.Date(appointment.getDate().getTime()));
			preparedStatement.setTime(2, new Time(appointment.getTime().getTime()));
			preparedStatement.setString(3, appointment.getStatus());
			preparedStatement.setInt(4, appointment.getJobSeeker().getJobSeekerId());
			preparedStatement.setInt(5, appointment.getConsultant().getId());
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				int appointmentId = generatedKeys.getInt(1);
				appointment.setId(appointmentId);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
	}

	public List<Appointment> getAppointmentsForUser(User user) {
		List<Appointment> userAppointments = new ArrayList<>();
		String sql = "SELECT * FROM appointments WHERE job_seeker_id = ? OR consultant_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setInt(2, user.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				java.util.Date date = new java.util.Date(resultSet.getDate("date").getTime());
				Time time = resultSet.getTime("time");
				String status = resultSet.getString("status");
				int jobSeekerId = resultSet.getInt("job_seeker_id");
				int consultantId = resultSet.getInt("consultant_id");

				JobSeeker jobSeeker = getJobSeekerById(jobSeekerId);
				Consultant consultant = getConsultantById(consultantId);

				Appointment appointment = new Appointment(id, date, time, status, jobSeeker, consultant);
				userAppointments.add(appointment);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
		return userAppointments;
	}

	// Report-related database operations
	public void addReport(Report report) {
		String sql = "INSERT INTO reports (report_type, content) VALUES (?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, report.getReportType());
			preparedStatement.setString(2, report.getContent());
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				int reportId = generatedKeys.getInt(1);
				report.setReportId(reportId);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
	}

	public List<Report> getReports() {
		List<Report> reportList = new ArrayList<>();
		String sql = "SELECT * FROM reports";
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				int reportId = resultSet.getInt("report_id");
				String reportType = resultSet.getString("report_type");
				String content = resultSet.getString("content");

				Report report = new Report(reportId, reportType, content);
				reportList.add(report);
			}
		} catch (SQLException e) {
			handleDatabaseError(e);
		}
		return reportList;
	}

	public void saveData(String userInput, Date futureDate1) {
		// TODO Auto-generated method stub

	}

	// error handling function
	private void handleDatabaseError(SQLException e) {
		e.printStackTrace();
		// You can log the error, throw custom exceptions, or handle it in a way that
		// fits your application's requirements.
	}

	private void handleDatabaseConnectionError(SQLException e) {
		e.printStackTrace();
		// Handle connection errors (e.g., log them, notify the user, etc.).
	}



}
