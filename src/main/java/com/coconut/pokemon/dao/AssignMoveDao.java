package com.coconut.pokemon.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.coconut.pokemon.entity.PokeMove;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AssignMoveDao implements AssignMoveDaoInterface {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  @Override
  public PokeMove assignMove(PokeMove pokeMove) {
  
    //formatter:off
    String sql = ""
        + "INSERT INTO poke_moves (move_name, pokemon_name)"        
        + "VALUES (:move_name, :pokemon_name);";
    //formatter:on        
   
    String moveName = pokeMove.getMoveName();
    String pokemonName = pokeMove.getPokemonName();
    
    
    
    Map<String, Object> params = new HashMap<>();
    params.put("pokemon_name", pokemonName);
    params.put("move_name", moveName);
    
   
   
    jdbcTemplate.update(sql, params);
        
    return PokeMove.builder()
        .moveName(moveName)
        .pokemonName(pokemonName)               
        .build();
    }
}
