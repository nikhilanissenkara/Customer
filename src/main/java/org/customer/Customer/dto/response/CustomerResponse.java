package org.customer.Customer.dto.response;

import org.customer.Customer.entity.Offer;

public class CustomerResponse {
    private Integer customerId;
    private String dateOfBirth;
    private String email;
    private String firstName;
    private String LastName;
    private Offer offer;

    public CustomerResponse(){

    }

    public CustomerResponse(Integer customerId){
        this.customerId=customerId;
    }

    public CustomerResponse(Integer customerId, String dateOfBirth, String email, String firstName, String lastName, Offer offer) {
        this.customerId = customerId;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstName = firstName;
        this.LastName = lastName;
        this.offer = offer;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "{" +
                "customerId='" + customerId + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}

