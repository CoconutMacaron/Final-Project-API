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
public class UpdatePokeDao implements UpdatePokeDaoInterface {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Pokemon updatePokemon(Pokemon pokemon) {
//formatter:off
  String sql = ""
      + "UPDATE pokemon "
      + "SET name = :name, type_1 = :type_1, type_2 = :type_2, region = :region, legendary = :legendary "
      + "WHERE (pokemon_id = :pokemon_id);";
  //formatter:on        
 
  Long pokemonID = pokemon.getPokemonID();
  String name = pokemon.getName();
  String type1 = pokemon.getType1();
  String type2 = pokemon.getType2();
  String region = pokemon.getRegion();
  String legendary = pokemon.getLegendary();
  
  
  Map<String, Object> params = new HashMap<>();
  params.put("pokemon_id", pokemonID);
  params.put("name", name);
  params.put("type_1", type1);     
  if (params.put("type_2", type2) == "") {
    params.put("type_2", "");
  } else {
    params.put("type_2", type2);
  }
  
  params.put("region", region);
  params.put("legendary", legendary);
 
 
  jdbcTemplate.update(sql, params);
      
  return Pokemon.builder()
      .pokemonID(pokemonID)
      .name(name)
      .type1(type1)
      .type2(type2)
      .region(region)
      .legendary(legendary)        
      .build();
      
  }
             
}
