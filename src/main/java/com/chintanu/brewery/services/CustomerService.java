package com.chintanu.brewery.services;

import com.chintanu.brewery.web.model.CustomerVO;

import java.util.UUID;

public interface CustomerService {

    CustomerVO getCustomerById(UUID customerId);

    CustomerVO saveNewCustomer(CustomerVO customerVO);

    void updateCustomer(UUID customerId, CustomerVO customerVO);

    void deleteCustomer(UUID customerId);
}
