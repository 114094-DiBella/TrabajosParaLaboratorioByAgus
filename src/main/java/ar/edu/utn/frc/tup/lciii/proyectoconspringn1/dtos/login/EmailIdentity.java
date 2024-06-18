package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO (Data Transfer Object) utilizado para manejar la identidad de un usuario mediante su correo electrónico.
 * Extiende de la clase Identity y contiene un campo para almacenar el email del jugador.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailIdentity extends Identity{

    @Schema(title = "Email to logged in",
            description = "The player email",
            example = "email@email.com",
            nullable = false)
    @NotNull(message = "email can't by null")
    @JsonProperty("email")
    private String email;
}
