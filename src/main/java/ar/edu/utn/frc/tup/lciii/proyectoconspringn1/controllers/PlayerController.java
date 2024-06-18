package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.controllers;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.common.ErrorApi;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Player;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.MatchService;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

/**
 * Controlador REST para manejar operaciones relacionadas con jugadores (players).
 * Utiliza anotaciones de Spring MVC como @RestController, @RequestMapping, @GetMapping, @PostMapping, etc.
 */
@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;

    @Operation(summary = "Get player by ID", description = "Returns a player by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "404", description = "Player not found", content = @Content(schema = @Schema(implementation = ErrorApi.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorApi.class)))
    })
    /**
     * Maneja peticiones GET para obtener un jugador por su ID.
     *
     * @param id el ID del jugador a recuperar
     * @return ResponseEntity con el jugador encontrado y código de estado HTTP 200 si existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id){
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @Operation(summary = "Save a new player", description = "Creates and saves a new player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player saved successfully", content = @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, username or email already exists", content = @Content(schema = @Schema(implementation = ErrorApi.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorApi.class)))
    })

    /**
     * Maneja peticiones POST para guardar un nuevo jugador.
     *
     * @param player el jugador a guardar, validado con @Valid
     * @return ResponseEntity con el jugador guardado y código de estado HTTP 200 si se guarda correctamente,
     *         o código de estado HTTP 400 si ya existe un jugador con el mismo username o email
     */
    @PostMapping("")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid Player player){
        Player playerSaved = playerService.savePlayer(player);
        if(Objects.isNull(playerSaved)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or email already exists");
        } else {
            return ResponseEntity.ok(playerSaved);
        }
    }
    @GetMapping("/{id}/matches")
    public ResponseEntity<List<Match>> getMatchesOfPlayer(@PathVariable Long id){
        List<Match> matches = matchService.getMatchesByPlayer(id);
        return ResponseEntity.ok(matches);
    }

}

