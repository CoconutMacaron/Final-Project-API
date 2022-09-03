package com.coconut.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coconut.pokemon.dao.UpdatePokeDaoInterface;
import com.coconut.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UpdatePokeService implements UpdatePokeServiceInterface {

  @Autowired
  private UpdatePokeDaoInterface updatePokeDaoInterface;

  @Override
  public Pokemon updatePokemon(Pokemon pokemon) {
    
    Pokemon updatedPokemon = updatePokeDaoInterface.updatePokemon(pokemon);
    
    return updatedPokemon;
  }
}
