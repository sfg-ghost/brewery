package com.chintanu.brewery.services;

import com.chintanu.brewery.web.model.BeerVO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerVO getBeerById(UUID beerId) {
        return BeerVO.builder()
                .beerName("Budweiser")
                .beerStyle("Mild")
                .id(UUID.randomUUID())
                .upc(3L)
                .build();
    }

    @Override
    public BeerVO saveNewBeer(BeerVO beerVO) {
        return BeerVO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerVO beerVO) {
        System.out.println("Beer Updated, Stub to be filled later.");
    }

    @Override
    public void deleteBeer(UUID beerId) {
        System.out.println("Beer Deleted, Stub to be filled later.");
    }
}
