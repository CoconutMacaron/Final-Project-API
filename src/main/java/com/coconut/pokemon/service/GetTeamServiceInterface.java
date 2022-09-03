package com.coconut.pokemon.service;

import java.util.List;
import com.coconut.pokemon.entity.Team;

public interface GetTeamServiceInterface {

  List<Team> fetchTeam(Long teamID, String name);
}
