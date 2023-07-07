package com.Alexander.mssBrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Alexander.mssBrewery.services.CustomerService;
import com.Alexander.mssBrewery.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")

@RestController
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping({"/{customerId}"})
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
    return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
  }

  @PostMapping  
  public ResponseEntity<CustomerDto> createCustomer( @RequestBody CustomerDto customerDto ){
    CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
    HttpHeaders headers = new HttpHeaders();

    // TODO añadir el hostname ej: http://localhost:8080
    headers.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

    return new ResponseEntity<CustomerDto>(headers,  HttpStatus.CREATED);
  }

    @PutMapping({"/{customerId}"})
  public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
    customerService.updateCustomer(customerId, customerDto);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping({"/{customerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("customerId") UUID customerId){
    customerService.deleteById(customerId);
  }


}
