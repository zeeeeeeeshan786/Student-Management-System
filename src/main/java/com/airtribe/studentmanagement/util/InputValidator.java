package main.java.com.airtribe.studentmanagement.util;

import main.java.com.airtribe.studentmanagement.exception.InvalidDataException;

public class InputValidator {
    public static void validateStudentId(String stdId) throws InvalidDataException {
        String idPatternMatcher = "^ATB\\d{3}$";
        if (stdId == null || stdId.isBlank()) {
            throw new InvalidDataException("Student ID Cannot be empty, it should be of the form ATB### where ### are numbers");
        } else if (!stdId.startsWith("ATB")) {
            throw new InvalidDataException("Student ID should be of the form ATB### ");
        } else if (!stdId.matches(idPatternMatcher)) {
            throw new InvalidDataException("Student ID should be of the form ATB### where ### is a 3 digit Number");
        }
    }

    public static void validateDobFormat(String providedDob) throws InvalidDataException {
        String dobPatternMatcher = "^\\d{2}-\\d{2}-\\d{4}$";
        if (!providedDob.matches(dobPatternMatcher) || providedDob.isBlank()) {
            throw new InvalidDataException("DOB must be in format dd-mm-yyyy, e.g. 27-06-2000");
        }
    }
}
