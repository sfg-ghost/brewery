package com.chintanu.brewery.web.controller;

import com.chintanu.brewery.services.BeerService;
import com.chintanu.brewery.services.CustomerService;
import com.chintanu.brewery.web.model.BeerVO;
import com.chintanu.brewery.web.model.CustomerVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerVO> getBeer(@PathVariable UUID customerId) {

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerVO customerVO) {

        CustomerVO savedCustomer = customerService.saveNewCustomer(customerVO);

        // The following adds a Location Header in the response. The result URL looks like : http://localhost:8080/api/v1/beer/e5729578-01d8-4a91-ad73-28bd3d00475a
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{customerId}")
                .buildAndExpand(savedCustomer.getId())
                .toUri();

        return ResponseEntity.created(location).build();

        /**
         * The above thing can also be done by directly adding the Location header e.g. -
         *
         *    HttpHeaders headers = new HttpHeaders();
         *    headers.add("Location", savedCustomer.getId());
         *    return new ResponseEntity(headers, HttpStatus.CREATED);
         */
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handlePut(@PathVariable UUID customerId, @RequestBody CustomerVO customerVO) {

        customerService.updateCustomer(customerId, customerVO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId) {

        customerService.deleteCustomer(customerId);
    }
}
