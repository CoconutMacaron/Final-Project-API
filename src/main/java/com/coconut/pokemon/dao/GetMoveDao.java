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
import com.coconut.pokemon.entity.Moves;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetMoveDao implements GetMoveDaoInterface {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Moves> fetchMoves(Long moveID, String name, String type, String category) {
    log.debug("DAO: moveID={}, name={}, type={}, category={}", moveID, name, type, category);
    String sql = ""
        + "SELECT * "
        + "FROM moves "
        + "WHERE move_id = :move_id OR name = :name OR type = :type OR category = :category";
    
    Map<String, Object> params = new HashMap<>();
    params.put("move_id", moveID);
    params.put("name", name);
    params.put("type", type);
    params.put("category", category);    
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
            
      public Moves mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Moves.builder()
            .moveID(rs.getLong("move_id"))
            .name(rs.getString("name"))
            .type(rs.getString("type"))
            .category(rs.getString("category"))                           
            .build();
      }});
        
  }
    
}
