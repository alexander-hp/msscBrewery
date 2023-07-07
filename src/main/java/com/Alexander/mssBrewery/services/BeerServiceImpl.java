package com.Alexander.mssBrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Alexander.mssBrewery.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{
  @Override 
  public BeerDto getBeerById(UUID beerId){
    return BeerDto.builder()
      .id(UUID.randomUUID())
      .beerName("GalaxyCat")
      .beerStyle("Pale Ate")
      .build();
  }

  @Override
  public BeerDto saveNewBeer(BeerDto beerDto) {
    // TODO Auto-generated method stub
    return BeerDto.builder()
      .id(UUID.randomUUID())
      .build();
  }

  @Override
  public void updateBeer(UUID beerId, BeerDto beerdto){

  }
  
  @Override
  public void deleteById(UUID beerId){
    log.debug("deleting a beer ...");
  }
}
