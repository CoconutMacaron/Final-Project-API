package com.coconut.pokemon.dao;

import java.util.List;
import com.coconut.pokemon.entity.Moves;

public interface GetMoveDaoInterface {

  List<Moves> fetchMoves(Long moveID, String name, String type, String category);

}
