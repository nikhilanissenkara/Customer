package org.customer.Customer.mapper;

import org.customer.Customer.dto.request.CustomerRequest;
import org.customer.Customer.dto.request.OfferRequest;
import org.customer.Customer.dto.response.CustomerResponse;
import org.customer.Customer.dto.response.OfferResponse;
import org.customer.Customer.entity.Customer;
import org.customer.Customer.entity.Offer;

public class Mapper {
    public Customer convertToEntity(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setCustomerId(customerRequest.getCustomerId());
        customer.setDateOfBirth(customerRequest.getDateOfBirth());
        customer.setEmail(customerRequest.getEmail());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setOffer(customer.getOffer());
        return customer;
    }

    public Offer convertToOfferEntity(OfferRequest customerRequest) {
        Offer offer=new Offer();
        offer.setOfferId(customerRequest.getOfferId());
        offer.setCallQty(customerRequest.getCallQty());
        offer.setCost(customerRequest.getCost());
        offer.setDataQty(customerRequest.getDataQty());
        offer.setDuration(customerRequest.getDuration());
        offer.setOfferName(customerRequest.getOfferName());
        return offer;
    }

    public CustomerResponse converToResponse(Customer customer) {
        return new CustomerResponse(customer.getCustomerId(), customer.getDateOfBirth(), customer.getEmail(), customer.getFirstName(),customer.getLastName(), customer.getOffer());
    }

    public OfferResponse converToOfferResponse(Offer offer) {
        return new OfferResponse(offer.getOfferId(),offer.getCallQty(),offer.getCost(),offer.getDataQty(),offer.getDuration(),offer.getOfferName());
    }
}

