package com.coconut.pokemon.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Team {

  private Long teamID;
  private String name;
  
  
}
