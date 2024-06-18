package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.utils.validations.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

/**
 * Clase modelo que representa a un jugador (player).
 * Utiliza Lombok para generar automáticamente getters, setters, constructores y otros métodos.
 */
@Data  // Genera automáticamente getters, setters, toString, equals, hashCode
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
public class Player {
    @Schema(title = "Player ID", description = "The Player ID", example = "1")
    private Long id;  // Identificador único del jugador

    @Schema(title = "Player user name", description = "The Player user name", example = "myUserName", nullable = false)
    @NotNull(message = "UserName can't be null")  // Validación: el nombre de usuario no puede ser nulo
    private String userName;  // Nombre de usuario del jugador

    @Schema(title = "Player password", description = "The Player password", example = "password", nullable = false)
    @NotNull(message = "Password can't be null")  // Validación: la contraseña no puede ser nula
    @ValidPassword  // Validación personalizada utilizando una anotación propia (ValidPassword)
    private String password;  // Contraseña del jugador

    @Schema(title = "Player email", description = "The Player email", example = "email@email.com", nullable = false)
    @NotNull(message = "The email can't be null")  // Validación: el email no puede ser nulo
    @Email(message = "The email can't be null")  // Validación: el formato del email debe ser válido
    private String email;  // Dirección de correo electrónico del jugador

    @Schema(title = "Player avatar", description = "The Player avatar", example = "https://localhosto:8080/avatars/", nullable = false)
    private String avatar;  // URL o nombre de archivo del avatar del jugador

    @Schema(title = "Player lastLogin", description = "The Player lastLogin", example = "01-01-2000 21:00:15", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")  // Formato de serialización/deserialización para lastLogin
    private LocalDateTime lastLogin;  // Fecha y hora del último inicio de sesión del jugador
}
