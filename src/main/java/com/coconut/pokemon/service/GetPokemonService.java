package com.coconut.pokemon.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coconut.pokemon.dao.GetPokemonDaoInterface;
import com.coconut.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetPokemonService implements GetPokemonServiceInterface {

  @Autowired
  private GetPokemonDaoInterface getPokemonDaoInterface;
  
  @Override
  public List<Pokemon> fetchPokemons(Long pokemonID, String name, String type1, String type2,
      String region, String legendary) {
    
    List<Pokemon> Pokemons = getPokemonDaoInterface.fetchPokemons(pokemonID, name, type1, type2, region, legendary);
    
    return Pokemons;
  }
  
}
