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
import com.coconut.pokemon.entity.Team;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetTeamDao implements GetTeamDaoInterface {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Team> fetchTeam(Long teamID, String name) {

    String sql = ""
        + "SELECT * "
        + "FROM team "
        + "WHERE team_id <= :team_id OR name = :name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("team_id", teamID);
    params.put("name", name);    
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
            
      public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Team.builder()
            .teamID(rs.getLong("team_id"))
            .name(rs.getString("name"))                            
            .build();
      }});
          
  }
}
