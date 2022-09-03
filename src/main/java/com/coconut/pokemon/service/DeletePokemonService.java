package com.coconut.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coconut.pokemon.dao.DeletePokemonDaoInterface;
import com.coconut.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeletePokemonService implements DeletePokemonServiceInterface {

  @Autowired
  private DeletePokemonDaoInterface deletePokemonDaoInterface;
  
  @Override
  public Pokemon deletePokemon(String name) {
    Pokemon oldPokemon = deletePokemonDaoInterface.deletePokemon(name);
    return oldPokemon;
  }

  
}
