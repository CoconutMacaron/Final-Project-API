package com.coconut.pokemon.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.coconut.pokemon.entity.Pokemon;
import com.coconut.pokemon.service.GetPokemonServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GetPokemonController implements GetPokemonControllerInterface{

  @Autowired
  private GetPokemonServiceInterface getPokemonServiceInterface;
  
  @Override
  public List<Pokemon> fetchPokemons(Long pokemonID, String name, String type1, String type2,
      String region, String legendary) {
    
    return getPokemonServiceInterface.fetchPokemons(pokemonID, name, type1, type2, region, legendary);
  }

}
