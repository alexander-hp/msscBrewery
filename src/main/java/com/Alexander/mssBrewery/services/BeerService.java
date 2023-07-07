package com.Alexander.mssBrewery.services;

import java.util.UUID;

import com.Alexander.mssBrewery.web.model.BeerDto;

public interface BeerService {

  BeerDto getBeerById(UUID beerId);

  BeerDto saveNewBeer(BeerDto beerDto);

  void updateBeer(UUID beerId, BeerDto beerDto);

  void deleteById(UUID beerId);

}
