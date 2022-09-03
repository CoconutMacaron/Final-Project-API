package com.coconut.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.coconut.pokemon.entity.Pokemon;
import com.coconut.pokemon.service.UpdatePokeServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UpdatePokeController implements UpdatePokeControllerInterface {

  @Autowired
  private UpdatePokeServiceInterface updatePokeServiceInterface;
  
  @Override
  public Pokemon updatePokemon(Pokemon pokemon) {
    
    return updatePokeServiceInterface.updatePokemon(pokemon);
  }
}
