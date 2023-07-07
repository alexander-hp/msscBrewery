package com.Alexander.mssBrewery.web.model;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// Para crear getters y setters
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BeerDto{
  private UUID id;
  private String beerName;
  private String beerStyle;
  private Long upc;
}