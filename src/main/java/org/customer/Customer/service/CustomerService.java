package org.customer.Customer.service;

import org.customer.Customer.dto.request.CustomerRequest;
import org.customer.Customer.dto.request.OfferRequest;
import org.customer.Customer.dto.response.CustomerResponse;
import org.customer.Customer.dto.response.OfferResponse;
import org.customer.Customer.exception.CustomerException;

import java.util.List;

public interface CustomerService {
    CustomerResponse getCustomerById(CustomerRequest customerRequest) throws CustomerException;
    OfferResponse getOffer(OfferRequest offerRequest) throws CustomerException;
    List<CustomerResponse> getAllCustomers();
    List<OfferResponse> getAllOffers();
    OfferResponse addOffer(OfferRequest offerRequest) throws CustomerException;
    CustomerResponse updateCustomer(CustomerRequest customerRequest) throws CustomerException;
    OfferResponse deleteOffer(OfferRequest offerRequest) throws CustomerException;
}
