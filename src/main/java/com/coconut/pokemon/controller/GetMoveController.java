package com.coconut.pokemon.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.coconut.pokemon.entity.Moves;
import com.coconut.pokemon.service.GetMoveServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GetMoveController implements GetMoveControllerInterface {
  
  @Autowired
  private GetMoveServiceInterface getMoveServiceInterface;
  
  @Override
  public List<Moves> fetchMoves(Long moveID, String name, String type, String category) {
    log.info("moveID={}, name={}, type={}, category={}", moveID, name, type, category);
    return getMoveServiceInterface.fetchMoves(moveID, name, type, category);
  }
}
