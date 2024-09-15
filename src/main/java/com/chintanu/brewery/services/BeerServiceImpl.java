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
}
