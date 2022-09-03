package com.coconut.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coconut.pokemon.dao.AssignMoveDaoInterface;
import com.coconut.pokemon.entity.PokeMove;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AssignMoveService implements AssignMoveServiceInterface {
  
  @Autowired
  private AssignMoveDaoInterface assignMoveDaoInterface;
  
  @Transactional
  @Override
  public PokeMove assignMove(PokeMove pokeMove) {
    
    PokeMove newAssign = assignMoveDaoInterface.assignMove(pokeMove);
    
    return newAssign;
  }

}
