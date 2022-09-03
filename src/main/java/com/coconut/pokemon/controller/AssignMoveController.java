package com.coconut.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.coconut.pokemon.entity.PokeMove;
import com.coconut.pokemon.service.AssignMoveServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AssignMoveController implements AssignMoveControllerInterface {

  @Autowired
  private AssignMoveServiceInterface assignMoveServiceInterface;
  
  @Override
  public PokeMove assignMove(PokeMove pokeMove) {
  
  return assignMoveServiceInterface.assignMove(pokeMove);
  }
}
