package com.coconut.pokemon.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.coconut.pokemon.entity.Team;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CreateTeamDao implements CreateTeamDaoInterface {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Team createTeam(Team team) {
  
    //formatter:off
    String sql = ""
        + "INSERT INTO team (team_id, name)"        
        + "VALUES (:team_id, :name);";
    //formatter:on        
   
    Long teamID = team.getTeamID();
    String name = team.getName();   
    
    
    Map<String, Object> params = new HashMap<>();
    params.put("team_id", teamID);
    params.put("name", name);
    
   
   
    jdbcTemplate.update(sql, params);
        
    return Team.builder()
        .teamID(teamID)
        .name(name)                
        .build();
    }
}
