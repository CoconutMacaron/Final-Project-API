package com.coconut.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coconut.pokemon.dao.CreateTeamDaoInterface;
import com.coconut.pokemon.entity.Team;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreateTeamService implements CreateTeamServiceInterface {

  
  @Autowired
  private CreateTeamDaoInterface createTeamDaoInterface;
  
  
  @Transactional
  @Override
  public Team createTeam(Team team) {       
        
    Team newMember = createTeamDaoInterface.createTeam(team);
    
    return newMember;
   }
    
}

