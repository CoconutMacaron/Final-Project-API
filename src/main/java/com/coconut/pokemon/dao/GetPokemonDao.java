package com.coconut.pokemon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.coconut.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetPokemonDao implements GetPokemonDaoInterface {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Pokemon> fetchPokemons(Long pokemonID, String name, String type1, String type2,
      String region, String legendary) {
  
    String sql = ""
        + "SELECT * "
        + "FROM pokemon "
        + "WHERE pokemon_id = :pokemon_id OR name = :name OR type_1 = :type_1 OR type_2 = :type_2 OR region = :region OR legendary = :legendary";
    
    Map<String, Object> params = new HashMap<>();
    params.put("pokemon_id", pokemonID);
    params.put("name", name);
    params.put("type_1", type1);
    params.put("type_2", type2);
    params.put("region", region);
    params.put("legendary", legendary);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
            
      public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Pokemon.builder()
            .pokemonID(rs.getLong("pokemon_id"))
            .name(rs.getString("name"))
            .type1(rs.getString("type_1"))
            .type2(rs.getString("type_2"))
            .region(rs.getString("region"))
            .legendary(rs.getString("legendary"))                
            .build();
      }});
      
  }
  
}
