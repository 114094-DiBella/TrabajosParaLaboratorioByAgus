package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.controllers;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.common.ErrorApi;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.Credential;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.CredentialV2;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Player;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.LoginService;
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

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Operación para manejar el login de un jugador usando la versión Credential
    @Operation(
            summary = "Login to the application",
            description = "Allows a user to log in using either username or email and a password"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful operation",
                    content = @Content(schema = @Schema(implementation = String.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))
            )
    })
    @PostMapping("")
    public ResponseEntity<Player> loginPlayer(@RequestBody @Valid Credential credential) {
        // Imprime la credencial recibida (puede ser útil para debugging)
        System.out.println(credential);
        // Llama al método login del servicio y retorna la respuesta
           return ResponseEntity.ok(loginService.login(credential));

    }

    // Operación para manejar el login de un jugador usando la versión CredentialV2
    @Operation(
            summary = "Login to the application",
            description = "Allows a user to log in using either username or email and a password"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful operation",
                    content = @Content(schema = @Schema(implementation = String.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))
            )
    })

    @PostMapping("v/2")
    public ResponseEntity<Player> loginPlayer(@RequestBody @Valid CredentialV2 credentialV2) {

            return ResponseEntity.ok(loginService.login(credentialV2));

    }
}

