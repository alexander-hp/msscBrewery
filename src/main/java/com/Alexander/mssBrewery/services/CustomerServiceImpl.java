package com.Alexander.mssBrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Alexander.mssBrewery.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public CustomerDto getCustomerById(UUID customerId){
    return CustomerDto.builder()
      .id(UUID.randomUUID())
      .customerName("Alexander")
      .build();
  }

  @Override
  public CustomerDto saveNewCustomer(CustomerDto customerDto) {
    // TODO Auto-generated method stub
    return CustomerDto.builder()
      .id(UUID.randomUUID())
      .build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDto customerDto){

  }
  
  @Override
  public void deleteById(UUID customerId){
    log.debug("deleting a customer ...");
  }


}
