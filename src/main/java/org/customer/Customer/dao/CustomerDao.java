package org.customer.Customer.dao;

import org.customer.Customer.dto.response.CustomerResponse;
import org.customer.Customer.dto.response.OfferResponse;
import org.customer.Customer.entity.Customer;
import org.customer.Customer.entity.Offer;
import org.customer.Customer.exception.CustomerException;

import java.util.List;

public interface CustomerDao {
    CustomerResponse getCustomerById(Customer customer) throws CustomerException;
    OfferResponse getOffer(Offer offer) throws CustomerException;
    List<CustomerResponse> getAllCustomers();
    List<OfferResponse> getAllOffers();
    OfferResponse addOffer(Offer offer) throws CustomerException;
    CustomerResponse updateOffer(Customer customer) throws CustomerException;
    OfferResponse deleteOffer(Offer offer) throws CustomerException;
}
