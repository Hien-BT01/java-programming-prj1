package models;

import constant.Constant;

public class Customer {
    private String email;
    private String firstName;
    private String lastName;

    public Customer(String email, String firstName, String lastName) {
        if (!Constant.EMAIL_REGEX_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException(Constant.INVALID_EMAIL_FORMAT);
        }
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "Customer: " + this.firstName + " " + this.lastName + " (" + this.email + ")";
    }
}
