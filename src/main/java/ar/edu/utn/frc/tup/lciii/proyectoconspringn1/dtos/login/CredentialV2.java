package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) utilizado para manejar las credenciales de autenticación de usuarios en su versión 2.
 * Contiene la identidad del usuario (email o nombre de usuario) y la contraseña.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialV2 {

    @Schema(title = "Email or UserName to logged in",
            description = "The player email or username",
            example = "USERNAME or EMAIL",
            nullable = false)
    @NotNull(message = "identity can't by null")
    @JsonProperty("identity")
    private String identity;
    @NotNull(message = "password can't by null")
    private String password;

}
