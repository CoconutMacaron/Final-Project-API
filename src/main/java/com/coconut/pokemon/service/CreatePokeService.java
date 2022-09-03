package com.coconut.pokemon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coconut.pokemon.dao.CreatePokeDaoInterface;
import com.coconut.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreatePokeService implements CreatePokeServiceInterface {
  
  @Autowired
  private CreatePokeDaoInterface createPokeDaoInterface;
  
  @Transactional
  @Override
  public Pokemon createPokemon(Pokemon pokemon) {       
        
    Pokemon newPokemon = createPokeDaoInterface.createPokemon(pokemon);
    
    return newPokemon;
  }

  
}
