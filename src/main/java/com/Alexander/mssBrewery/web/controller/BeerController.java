package com.Alexander.mssBrewery.web.controller;

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

import com.Alexander.mssBrewery.services.BeerService;
import com.Alexander.mssBrewery.web.model.BeerDto;

import java.util.UUID;

// ? MVC Controller

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

  // ?Ya no hacemos @Autowired aqui porque se hara automaticamente ligado
  private final BeerService beerService;
  
  
  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }


  @GetMapping({"/{beerId}"})
  public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
    // ?Como se retornara la respuesta
    // return new ResponseEntity<BeerDto>( BeerDto.builder().build(), HttpStatus.OK);
    return new ResponseEntity<BeerDto>( beerService.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity handlePost(@RequestBody BeerDto beerDto){
    BeerDto savedDto = beerService.saveNewBeer(beerDto);
    HttpHeaders headers = new HttpHeaders();

    // TODO añadir el hostname ej: http://localhost:8080
    headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

    return new ResponseEntity<>( headers, HttpStatus.CREATED);

  }

  @PutMapping({"/{beerId}"})
  public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
    beerService.updateBeer(beerId, beerDto);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping({"/{beerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId){
    beerService.deleteById(beerId);
  }

}
