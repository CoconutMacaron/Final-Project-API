package com.coconut.pokemon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.coconut.pokemon.entity.Pokemon;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/DeleteAPokemon")
@OpenAPIDefinition(info = @Info(title = "Pokemon Teams Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface DeletePokemonControllerInterface {
 
    //formatter:off
      @Operation(
          summary = "Delete an available pokemon",
          description = "Deletes a pokemon",
          responses = {
              @ApiResponse(
                  responseCode = "200",
                  description = "The deleted pokemon is confirmed and returned",
                  content = @Content(mediaType = "application/json")),                                    
              @ApiResponse(
                  responseCode = "400",
                  description = "The request parameters are invalid",
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404",
                  description = "A pokemon could not be found with the input criteria",
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500",
                  description = "An unplanned error occurred",
                  content = @Content(mediaType = "application/json"))

          },
          parameters = {
              
              @Parameter(
                  name = "name",
                  allowEmptyValue = false,
                  required = true, 
                  description = "The Pokemon's name you would like to delete")              
          }        
        )
      @DeleteMapping(value = "{name}")
      @ResponseStatus(code = HttpStatus.OK)
      Pokemon deletePokemon(             
            @RequestParam 
            String name);    
  //formatter:on    
}
