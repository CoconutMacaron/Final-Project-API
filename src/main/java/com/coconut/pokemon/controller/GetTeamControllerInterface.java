package com.coconut.pokemon.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.coconut.pokemon.entity.Team;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/GetTeam")
@OpenAPIDefinition(info = @Info(title = "Pokemon Teams Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface GetTeamControllerInterface {

  //formatter:off
    @Operation(
        summary = "Returns a list of the current Pokemon team",
        description = "Returns a list of the current Pokemon team",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "The team of pokemon is returned",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Team.class))),              
            @ApiResponse(
                responseCode = "400",
                description = "The request parameters are invalid",
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404",
                description = "No pokemon were found on the team",
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500",
                description = "An unplanned error occurred",
                content = @Content(mediaType = "application/json"))

        },
        parameters = {
            @Parameter(
                name = "teamID",
                allowEmptyValue = false,
                required = false, 
                description = "Select how many team members you would like to view."),
            @Parameter(
                name = "name",
                allowEmptyValue = false,
                required = false, 
                description = "Alternatively, select a team member's name.")            
        }
        
      )  
    
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Team> fetchTeam(
        @RequestParam(required = false) 
          Long teamID, 
        @RequestParam(required = false) 
          String name);
        
  //formatter:on
}
