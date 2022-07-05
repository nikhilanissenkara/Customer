package org.customer.Customer.controller;

import org.assertj.core.api.Assertions;
import org.customer.Customer.exception.CustomerException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @Test
     void getCustomerById() throws CustomerException {
        Assertions.assertThat(customerController).isNot(null);
    }

    @Test
    void getOffer() {
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void getAllOffers() {
    }

    @Test
    void addOffer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteOffer() {
    }
}