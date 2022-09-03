package com.coconut.pokemon.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coconut.pokemon.dao.GetMoveDaoInterface;
import com.coconut.pokemon.entity.Moves;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetMoveService implements GetMoveServiceInterface {

  @Autowired
  private GetMoveDaoInterface getMoveDaoInterface;
  
  @Override
  public List<Moves> fetchMoves(Long moveID, String name, String type, String category) {
    log.info("The fetchMoves method was called with moveID={}, name={}, type={}, category={}", moveID, name, type, category);
    
    List<Moves> Moves = getMoveDaoInterface.fetchMoves(moveID, name, type, category);
        
    return Moves;
  }

}
