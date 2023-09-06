package com.tdsolution.classes;

public class ValidationUtils {
	public static boolean isValidEmail(String email) {
		// Basic email validation using a regular expression
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		return email.matches(emailRegex);
	}

	public static boolean isValidPhoneNumber(String phoneNumber) {
		// Basic phone number validation (for demonstration purposes)
		return phoneNumber.matches("^\\d{10}$");
	}

	public static boolean isNotEmpty(String value) {
		// Check if a string is not empty or null
		return value != null && !value.trim().isEmpty();
	}

	public static boolean isValidDate(String date) {
		// Basic date validation (for demonstration purposes)
		return date.matches("^\\d{4}-\\d{2}-\\d{2}$");
	}

	public boolean isValidInput(String input) {
		// Check if the input is not null and not empty
		if (input != null && !input.isEmpty()) {
			// Check if the input contains only alphanumeric characters
			if (input.matches("^[a-zA-Z0-9]+$")) {
				// Check if the input has a minimum length (e.g., 3 characters)
				if (input.length() >= 3) {
					return true; // Input is valid
				}
			}
		}
		return false; // Input is not valid
	}

	// Add more validation methods as needed

	public static void main(String[] args) {
		// Example usage
		String email = "example@email.com";
		String phoneNumber = "1234567890";
		String nonEmptyString = "Hello, World!";
		String date = "2023-09-01";

		System.out.println("Email is valid: " + isValidEmail(email));
		System.out.println("Phone number is valid: " + isValidPhoneNumber(phoneNumber));
		System.out.println("String is not empty: " + isNotEmpty(nonEmptyString));
		System.out.println("Date is valid: " + isValidDate(date));
	}
}
