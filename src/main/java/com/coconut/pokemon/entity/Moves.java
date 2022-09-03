package com.coconut.pokemon.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Moves {

  private Long moveID;
  private String name;
  private String type;
  private String category;
  
}
