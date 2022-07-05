package org.customer.Customer.service.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.customer.Customer.controller.CustomerController;
import org.customer.Customer.dao.CustomerDao;
import org.customer.Customer.dto.request.CustomerRequest;
import org.customer.Customer.dto.request.OfferRequest;
import org.customer.Customer.dto.response.CustomerResponse;
import org.customer.Customer.dto.response.OfferResponse;
import org.customer.Customer.entity.Customer;
import org.customer.Customer.entity.Offer;
import org.customer.Customer.exception.CustomerException;
import org.customer.Customer.mapper.Mapper;
import org.customer.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private static final Log logger= LogFactory.getLog(CustomerServiceImpl.class);
    @Autowired
    private CustomerDao customerDao;
    private Mapper mapper=new Mapper();
    @Override
    public CustomerResponse getCustomerById(CustomerRequest customerRequest) throws CustomerException {
        Customer customer=mapper.convertToEntity(customerRequest);
        logger.info("In service get customer by id");
        return customerDao.getCustomerById(customer);
    }

    @Override
    public OfferResponse getOffer(OfferRequest offerRequest) throws CustomerException {
        Offer offer=mapper.convertToOfferEntity(offerRequest);
        return customerDao.getOffer(offer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
       return customerDao.getAllCustomers();
    }

    @Override
    public List<OfferResponse> getAllOffers() {
        return customerDao.getAllOffers();
    }

    @Override
    public OfferResponse addOffer(OfferRequest offerRequest) throws CustomerException {
        Offer offer=mapper.convertToOfferEntity(offerRequest);
        return customerDao.addOffer(offer);
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest) throws CustomerException {
        Customer customer= mapper.convertToEntity(customerRequest);
        return customerDao.updateOffer(customer);
    }

    @Override
    public OfferResponse deleteOffer(OfferRequest offerRequest) throws CustomerException {
        Offer offer= mapper.convertToOfferEntity(offerRequest);
        return customerDao.deleteOffer(offer);
    }
}
