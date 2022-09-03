package com.coconut.pokemon.dao;

import java.util.List;
import com.coconut.pokemon.entity.Pokemon;


public interface GetPokemonDaoInterface {

  List<Pokemon> fetchPokemons(Long pokemonID, String name, String type1, String type2,
      String region, String legendary);
}
 