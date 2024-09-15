package com.chintanu.brewery.services;

import com.chintanu.brewery.web.model.BeerVO;

import java.util.UUID;

public interface BeerService {

    BeerVO getBeerById(UUID beerId);
}
