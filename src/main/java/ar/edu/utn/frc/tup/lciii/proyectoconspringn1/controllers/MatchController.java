package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.controllers;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.match.MatchDTO;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.play.PlayRequest;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Play;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Player;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    /**
     * Maneja peticiones POST para guardar una nueva partida.
     *
     * @param matchDTO DTO que contiene la información de la partida a crear, validado con @Valid
     * @return ResponseEntity con la partida guardada y código de estado HTTP 200 si se guarda correctamente,
     *         o código de estado HTTP 400 si hay algún error en la solicitud
     */
    @PostMapping("")
    public ResponseEntity<Match> saveMatch(@RequestBody @Valid MatchDTO matchDTO){

        Match matchSaved = matchService.createMatch(matchDTO);

        // Verifica si la partida se guardó correctamente
        if(Objects.isNull(matchSaved)){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The request has an error");
        } else {
            // Retorna la partida guardada en la respuesta HTTP
            return ResponseEntity.ok(matchSaved);
        }
    }

    /**
     * Maneja peticiones GET para obtener una partida por su ID.
     *
     * @param id el ID de la partida a recuperar
     * @return ResponseEntity con la partida encontrada y código de estado HTTP 200 si existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<Match> getById(@PathVariable Long id){
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    /**
     * Maneja peticiones POST para realizar una jugada en una partida específica.
     *
     * @param id el ID de la partida donde se realizará la jugada
     * @param playRequest objeto que contiene la información de la jugada a realizar, validado con @Valid
     * @return ResponseEntity con el resultado de la jugada y código de estado HTTP 200 si se procesa correctamente,
     *         o código de estado HTTP 400 si hay algún error en la solicitud
     */
    // Endpoint para realizar una jugada en una partida específica
    @PostMapping("{id}/plays/")
    public ResponseEntity<Play> saveMatch(@PathVariable Long id, @RequestBody @Valid PlayRequest playRequest){
        Play playResult = matchService.play(id, playRequest);
        if(Objects.isNull(playRequest)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The request has an error");
        } else {
            return ResponseEntity.ok(playResult);
        }
    }
}
