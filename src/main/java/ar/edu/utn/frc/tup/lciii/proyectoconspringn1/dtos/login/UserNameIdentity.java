package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO (Data Transfer Object) utilizado para manejar la identidad de tipo usuario con nombre de usuario.
 * Extiende de la clase base Identity y utiliza anotaciones de Jackson para serialización/deserialización
 * y anotaciones de Swagger para documentación.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNameIdentity extends Identity {
    @Schema(title = "UserName",
            description = "The player UserName",
            example = "UserName",
            nullable = false)
    @NotNull(message = "UserName can't by null")
    @JsonProperty("user_name")
    private String userName;
}
