package com.coconut.pokemon.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.coconut.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DeletePokemonDao implements DeletePokemonDaoInterface {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Pokemon deletePokemon(String name) {
    String sql = ""
        + "DELETE FROM pokemon WHERE name = :name;";        
     
    Map<String, Object> params = new HashMap<>();    
    params.put("name", name);
   
    jdbcTemplate.update(sql, params);
        
    return Pokemon.builder()   
        .name(name)                     
        .build();
    }
  }


