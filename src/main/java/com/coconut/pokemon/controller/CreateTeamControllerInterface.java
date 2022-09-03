package com.coconut.pokemon.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.coconut.pokemon.entity.Team;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/CreateATeam")
@OpenAPIDefinition(info = @Info(title = "Pokemon Teams Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface CreateTeamControllerInterface {

//formatter:off
  @Operation(
      summary = "Create a new team member",
      description = "Returns the created team member",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "The team member is created and is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Team.class))),              
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "A team member could not be created with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json"))
          
      }
      
      
    )
  
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Team createTeam( 
      
      @Valid
      @RequestBody
        Team team); 
      
//formatter:on    

}
