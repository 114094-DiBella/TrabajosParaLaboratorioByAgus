package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.controllers;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.common.ErrorApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para manejar peticiones relacionadas con el ping-pong.
 */
@RestController
public class PingController {

    @Operation(
            summary = "Check healthy of the app",
            description = "If the app it's alive response pong")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Succesful operation",
                    content = @Content(
                            schema = @Schema(implementation = String.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorApi.class)
                    )
            )
    })
    /**
     * Maneja peticiones GET en la ruta '/ping'.
     * Retorna la cadena "pong" como respuesta.
     *
     * @return la cadena "pong"
     */

    @GetMapping("/ping")
    public String pong(){
        return "pong";
    }
}

