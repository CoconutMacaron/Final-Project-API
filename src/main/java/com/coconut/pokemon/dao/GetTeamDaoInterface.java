package com.coconut.pokemon.dao;

import java.util.List;
import com.coconut.pokemon.entity.Team;

public interface GetTeamDaoInterface {

   List<Team> fetchTeam(Long teamID, String name);
}
