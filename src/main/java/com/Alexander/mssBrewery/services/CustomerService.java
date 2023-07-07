package com.Alexander.mssBrewery.services;

import java.util.UUID;

import com.Alexander.mssBrewery.web.model.CustomerDto;

public interface CustomerService {
  CustomerDto getCustomerById(UUID id);

  CustomerDto saveNewCustomer(CustomerDto customerDto);

  void updateCustomer(UUID customerId, CustomerDto customerDto);

  void deleteById(UUID customerId);
}
