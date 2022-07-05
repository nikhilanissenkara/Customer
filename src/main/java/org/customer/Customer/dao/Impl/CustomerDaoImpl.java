package org.customer.Customer.dao.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.customer.Customer.controller.CustomerController;
import org.customer.Customer.dao.CustomerDao;
import org.customer.Customer.dto.response.CustomerResponse;
import org.customer.Customer.dto.response.OfferResponse;
import org.customer.Customer.entity.Customer;
import org.customer.Customer.entity.Offer;
import org.customer.Customer.exception.CustomerException;
import org.customer.Customer.mapper.Mapper;
import org.customer.Customer.repository.CustomerRepository;
import org.customer.Customer.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@PropertySource("messages.properties")
public class CustomerDaoImpl implements CustomerDao {

    private static final Log logger= LogFactory.getLog(CustomerDaoImpl.class);
    Mapper mapper=new Mapper();
    @Autowired
    private Environment environment;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OfferRepository offerRepository;
    @Override
    public CustomerResponse getCustomerById(Customer customer) throws CustomerException {

        Optional<Customer> optional= customerRepository.findById(customer.getCustomerId());
        Customer customerdetail=optional.orElseThrow(()->new CustomerException("Not Found"));
        logger.info("In dao get customer by id");
        return mapper.converToResponse(customerdetail);
    }

    @Override
    public OfferResponse getOffer(Offer offer) throws CustomerException {
        Offer offers= offerRepository.findByCallQtyAndDataQty(offer.getCallQty(),offer.getDataQty());
        return mapper.converToOfferResponse(offers);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customerList=customerRepository.findAll();
        List<CustomerResponse> customerResponses=customerList.stream().map(customer->mapper.converToResponse(customer)).collect(Collectors.toList());
        return customerResponses;
    }

    @Override
    public List<OfferResponse> getAllOffers() {
        List<Offer> offerList=offerRepository.findAll();
        List<OfferResponse> offerResponses=offerList.stream().map(offer->mapper.converToOfferResponse(offer)).collect(Collectors.toList());
        return offerResponses;
    }

    @Override
    public OfferResponse addOffer(Offer offer) throws CustomerException {
        Offer offers=offerRepository.save(offer);
        return mapper.converToOfferResponse(offers);
    }

    @Override
    public CustomerResponse updateOffer(Customer customer) throws CustomerException {
        Optional<Customer> optional= customerRepository.findById(customer.getCustomerId());
        Customer customerdetail=optional.orElseThrow(()->  new CustomerException(environment.getProperty("CustomerDaoImpl.Customer_NOT_FOUND")));
        customerdetail.setEmail(customer.getEmail());
        return mapper.converToResponse(customerdetail);
    }

    @Override
    public OfferResponse deleteOffer(Offer offer) throws CustomerException {
        Optional<Offer> optional= offerRepository.findById(offer.getOfferId());
        Offer offers=optional.orElseThrow(()->  new CustomerException(environment.getProperty("CustomerDaoImpl.Customer_NOT_FOUND")));
        offerRepository.delete(offers);
        return mapper.converToOfferResponse(offers);
    }
}
