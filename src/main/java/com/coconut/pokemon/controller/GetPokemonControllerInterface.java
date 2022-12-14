package com.coconut.pokemon.controller;

import com.coconut.pokemon.entity.Pokemon;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/GetAvailablePokemon")
@OpenAPIDefinition(info = @Info(title = "Pokemon Teams Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface GetPokemonControllerInterface {
//formatter:off
  @Operation(
      summary = "Returns a list of available pokemon",
      description = "Returns a list of available pokemon given your input specifications",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of applicable pokemon is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Pokemon.class))),              
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No available pokemon were found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json"))

      },
      parameters = {
          @Parameter(
              name = "pokemonID",
              allowEmptyValue = false,
              required = false, 
              description = "The Pokedex ID"),
          @Parameter(
              name = "name",
              allowEmptyValue = false,
              required = false, 
              description = "The Pokemon's name"),
          @Parameter(
              name = "type1",
              allowEmptyValue = false,
              required = false, 
              description = "The first type"),
          @Parameter(
              name = "type2",
              allowEmptyValue = true,
              required = false, 
              description = "The second type if applicable"),
          @Parameter(
              name = "region",
              allowEmptyValue = false,
              required = false, 
              description = "The Pokemon's home region"),
          @Parameter(
              name = "legendary",
              allowEmptyValue = true,
              required = false, 
              description = "Is the Pokemon Legendary? (Yes/No)")
      }
      
    )  
  
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Pokemon> fetchPokemons(
      @RequestParam(required = false) 
        Long pokemonID, 
      @RequestParam(required = false) 
        String name,
      @RequestParam(required = false) 
        String type1,
      @RequestParam(required = false) 
        String type2,
      @RequestParam(required = false) 
        String region,
      @RequestParam(required = false) 
        String legendary);
//formatter:on
}
