package com.chintanu.brewery.services;

import com.chintanu.brewery.web.model.CustomerVO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerVO getCustomerById(UUID customerId) {
        return CustomerVO.builder()
                .customerName("Rahul")
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerVO saveNewCustomer(CustomerVO customerVO) {
        return CustomerVO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerVO customerVO) {
        System.out.println("Customer Updated, Stub to be filled later.");
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        System.out.println("Customer Deleted, Stub to be filled later.");
    }
}
