package com.coconut.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.coconut.pokemon.entity.Pokemon;
import com.coconut.pokemon.service.CreatePokeServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CreatePokeController implements CreatePokeControllerInterface {

  @Autowired
  private CreatePokeServiceInterface createPokeServiceInterface;
  
  @Override
  public Pokemon createPokemon(Pokemon pokemon) {
    
    return createPokeServiceInterface.createPokemon(pokemon);
  }
}
