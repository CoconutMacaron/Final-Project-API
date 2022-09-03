package com.coconut.pokemon.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coconut.pokemon.dao.GetTeamDaoInterface;
import com.coconut.pokemon.entity.Team;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetTeamService implements GetTeamServiceInterface {
  
  @Autowired
  private GetTeamDaoInterface getTeamDaoInterface;
  
  @Override
  public List<Team> fetchTeam(Long teamID, String name) {
    
    List<Team> teamMembers = getTeamDaoInterface.fetchTeam(teamID, name);
    return teamMembers;
  }

}
