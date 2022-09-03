package com.coconut.pokemon.service;

import java.util.List;
import com.coconut.pokemon.entity.Moves;

public interface GetMoveServiceInterface {

  List<Moves> fetchMoves(Long moveID, String name, String type, String category);

}
