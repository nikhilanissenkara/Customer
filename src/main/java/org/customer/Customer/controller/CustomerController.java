package org.customer.Customer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.customer.Customer.dto.request.CustomerRequest;
import org.customer.Customer.dto.request.OfferRequest;
import org.customer.Customer.dto.response.CustomerResponse;
import org.customer.Customer.dto.response.OfferResponse;
import org.customer.Customer.entity.Offer;
import org.customer.Customer.exception.CustomerException;
import org.customer.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CustomerController {

    private static final Log logger= LogFactory.getLog(CustomerController.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private Environment environment;

    @GetMapping("/customer/byid")
    public ResponseEntity<CustomerResponse> getCustomerById(@RequestBody CustomerRequest customerRequest) throws CustomerException {
        try {
            logger.info("In controller get customer id");
            return new ResponseEntity<>(customerService.getCustomerById(customerRequest), HttpStatus.OK);
        }
        catch(CustomerException e){
            logger.error(environment.getProperty("CustomerDaoImpl.Customer_NOT_FOUND"));
        }
        return null;
    }

    @GetMapping("offer/offerbyid")
    public ResponseEntity<OfferResponse> getOffer(@RequestBody OfferRequest offerRequest) throws CustomerException {
        return new ResponseEntity<>(customerService.getOffer(offerRequest), HttpStatus.OK);
    }

    @GetMapping("allcustomers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @GetMapping("alloffers")
    public ResponseEntity<List<OfferResponse>> getAllOffers(){
        return new ResponseEntity<>(customerService.getAllOffers(),HttpStatus.OK);
    }

    @PostMapping("/offer/add")
    public ResponseEntity<OfferResponse> addOffer(@RequestBody OfferRequest offerRequest) throws CustomerException {
        return new ResponseEntity<>(customerService.addOffer(offerRequest),HttpStatus.OK);
    }

    @PutMapping("/customer/update")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerRequest customerRequest) throws CustomerException{
        customerService.updateCustomer(customerRequest);
        return new ResponseEntity<>(environment.getProperty("CustomerController.Customer_UPDATE_SUCCESS"),HttpStatus.OK);
    }

    @DeleteMapping("/offer/delete")
    public ResponseEntity<String> deleteOffer(@RequestBody OfferRequest offerRequest) throws CustomerException{
        customerService.deleteOffer(offerRequest);
        return new ResponseEntity<>(environment.getProperty("CustomerController.Customer_DELETE_SUCCESS"),HttpStatus.OK);
    }
}
