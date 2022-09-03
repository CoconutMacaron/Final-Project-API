package com.coconut.pokemon.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokeMove {

  private String moveName;
  private String pokemonName;
}
