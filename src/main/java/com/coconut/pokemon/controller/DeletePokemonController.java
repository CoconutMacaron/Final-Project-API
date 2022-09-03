package com.coconut.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.coconut.pokemon.entity.Pokemon;
import com.coconut.pokemon.service.DeletePokemonServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DeletePokemonController implements DeletePokemonControllerInterface {

  @Autowired
  private DeletePokemonServiceInterface deletePokemonServiceInterface;
  
  public Pokemon deletePokemon(String name) {
    return deletePokemonServiceInterface.deletePokemon(name);
  }
}
