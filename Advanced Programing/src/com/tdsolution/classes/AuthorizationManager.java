package com.tdsolution.classes;

import java.util.HashMap;
import java.util.Map;

public class AuthorizationManager {
	// Simulated user roles (you should replace this with actual user roles and
	// permissions)
	private static final String ROLE_ADMIN = "admin";
	private static final String ROLE_CONSULTANT = "consultant";
	private static final String ROLE_JOB_SEEKER = "job_seeker";

	// Simulated user credentials (replace with actual user data from your database)
	private static final Map<String, String> USER_CREDENTIALS = new HashMap<>();

	static {
		// Simulated user data (username and password)
		USER_CREDENTIALS.put("admin", "admin123");
		USER_CREDENTIALS.put("consultant", "consultant123");
		USER_CREDENTIALS.put("job_seeker", "jobseeker123");
	}

	public static boolean authenticateUser(String username, String password) {
		// Check if the provided credentials match the stored credentials
		String storedPassword = USER_CREDENTIALS.get(username);
		return storedPassword != null && storedPassword.equals(password);
	}

	public static boolean isUserInRole(String username, String role) {
		// Simulated role-based authorization (you should replace this with your
		// authorization logic)
		switch (role) {
		case ROLE_ADMIN:
			return username.equals("admin");
		case ROLE_CONSULTANT:
			return username.equals("consultant");
		case ROLE_JOB_SEEKER:
			return username.equals("job_seeker");
		default:
			return false;
		}
	}
}

