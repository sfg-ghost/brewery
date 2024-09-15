package com.chintanu.brewery.web.controller;

import com.chintanu.brewery.services.BeerService;
import com.chintanu.brewery.web.model.BeerVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerVO> getBeer(@PathVariable UUID beerId) {

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerVO beerVO) {

        BeerVO savedBeer = beerService.saveNewBeer(beerVO);

        // The following adds a Location Header in the response. The result URL looks like : http://localhost:8080/api/v1/beer/e5729578-01d8-4a91-ad73-28bd3d00475a
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{beerId}")
                .buildAndExpand(savedBeer.getId())
                .toUri();

        return ResponseEntity.created(location).build();

        /**
         * The above thing can also be done by directly adding the Location header e.g. -
         *
         *    HttpHeaders headers = new HttpHeaders();
         *    headers.add("Location", savedBeer.getId());
         *    return new ResponseEntity(headers, HttpStatus.CREATED);
         */
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handlePut(@PathVariable UUID beerId, @RequestBody BeerVO beerVO) {

        beerService.updateBeer(beerId, beerVO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId) {

        beerService.deleteBeer(beerId);
    }
}
