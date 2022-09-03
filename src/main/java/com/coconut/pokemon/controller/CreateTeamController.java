package com.coconut.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.coconut.pokemon.entity.Team;
import com.coconut.pokemon.service.CreateTeamServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CreateTeamController implements CreateTeamControllerInterface {

  @Autowired
  private CreateTeamServiceInterface createTeamServiceInterface;
  
  @Override
  public Team createTeam(Team team) {
    
    return createTeamServiceInterface.createTeam(team);
  }

}
