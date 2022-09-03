package com.coconut.pokemon.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.coconut.pokemon.entity.Pokemon;
import com.coconut.pokemon.entity.Team;
import com.coconut.pokemon.service.GetPokemonServiceInterface;
import com.coconut.pokemon.service.GetTeamServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GetTeamController implements GetTeamControllerInterface {

  @Autowired
  private GetTeamServiceInterface getTeamServiceInterface;
  
  @Override
  public List<Team> fetchTeam(Long teamID, String name) {
    
    return getTeamServiceInterface.fetchTeam(teamID, name);
  }
}
