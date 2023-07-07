package com.Alexander.mssBrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Alexander.mssBrewery.web.model.v2.BeerDtoV2;

@Service
public class BeerServiceImplV2 implements BeerServiceV2{

  @Override
  public BeerDtoV2 getBeerById(UUID beerId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getBeerById'");
  }

  @Override
  public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveNewBeer'");
  }

  @Override
  public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateBeer'");
  }

  @Override
  public void deleteById(UUID beerId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }
  
}
