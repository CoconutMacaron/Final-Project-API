package com.coconut.pokemon.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.coconut.pokemon.entity.Pokemon;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/UpdateAPokemon")
@OpenAPIDefinition(info = @Info(title = "Pokemon Teams Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UpdatePokeControllerInterface {

//formatter:off
  @Operation(
      summary = "Update an existing pokemon",
      description = "Returns the updated pokemon",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "The pokemon is updated and is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Pokemon.class))),              
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "A pokemon could not be updated with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json"))
          
      }      
      
    )
    
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Pokemon updatePokemon( 
      
      @Valid
      @RequestBody
        Pokemon pokemon); 
      
//formatter:on    
}
