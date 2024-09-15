package com.chintanu.brewery.services;

import com.chintanu.brewery.web.model.CustomerVO;

import java.util.UUID;

public interface CustomerService {

    CustomerVO getCustomerById(UUID beerId);
}
