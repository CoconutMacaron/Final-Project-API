package com.coconut.pokemon.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Pokemon {

  
  private Long pokemonID;
  private String name;
  private String type1; 
  private String type2;
  private String region;
  private String legendary;
}
