package com.chintanu.brewery.services;

import com.chintanu.brewery.web.model.BeerVO;

import java.util.UUID;

public interface BeerService {

    BeerVO getBeerById(UUID beerId);

    BeerVO saveNewBeer(BeerVO beerVO);

    void updateBeer(UUID beerId, BeerVO beerVO);

    void deleteBeer(UUID beerId);
}
