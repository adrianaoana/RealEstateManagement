package com.squad.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.squad.model.User;
import com.squad.service.UserService;


public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.field.required",
				new Object[] { "Email address" }, "Email address is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.field.required",
				new Object[] { "Password" }, "Password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.field.required",
				new Object[] { "Country" }, "Country is required");

		User user = (User) target;
		if (user.getEmail().length() >= 60) {
			errors.rejectValue("email", "longText", new Object[] { "Email address" },
					"The email address is too long");
		} else if (!validateEmailAddress(user.getEmail())) {
			errors.rejectValue("email", "invalidData", new Object[] { "Email address" },
					"Invalid email address");
		}
		if (user.getPassword().length() >= 20) {
			errors.rejectValue("password", "longText", new Object[] { "Password" },
					"The password is too long");
		}
		if (user.getPassword().length() < 6) {
			errors.rejectValue("password", "minText", new Object[] { "Password" },
					"The password is too short");
		}
		if (user.getCity() != null && !user.getCity().isEmpty()) {
			if (user.getCity().length() > 19) {
				errors.rejectValue("city", "longText", new Object[] { "The city" },
						"The city is too long");
			} 
		}
		if (user.getPhone() != null && !user.getPhone().isEmpty()) {
			if (user.getPhone().length() > 14) {
				errors.rejectValue("phone", "longText", new Object[] { "Phone" },
						"The phone is too long");
			} else {
				if (!validatePhoneNumber(user.getPhone())) {
					errors.rejectValue("phone", "invalidData", "Invalid phone");
				}
			}
		}

	}

	public static boolean validatePhoneNumber(String phoneNo) {
		// validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{10}"))
			return true;
		// validating phone number with -, . or spaces
		else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		// validating phone number with extension length from 3 to 5
		else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		// return false if nothing matches the input
		else
			return false;

	}

	public static boolean validateEmailAddress(String email) {
		if (email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))
			return true;
		return false;
	}
}
