package com.chintanu.brewery.services;

import com.chintanu.brewery.web.model.CustomerVO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerVO getCustomerById(UUID beerId) {
        return CustomerVO.builder()
                .customerName("Rahul")
                .id(UUID.randomUUID())
                .build();
    }
}
