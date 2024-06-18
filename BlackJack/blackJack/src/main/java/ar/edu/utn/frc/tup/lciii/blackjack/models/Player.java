package ar.edu.utn.frc.tup.lciii.blackjack.models;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Schema(title = "Player ID", description = "The Player ID", example = "1")
    private Long id;

    @Schema(title = "Player user name", description = "The Player user name", example = "myUserName", nullable = false)
    @NotNull(message = "UserName can't be null")
    private String userName;

    @Schema(title = "Player email", description = "The Player email", example = "email@email.com", nullable = false)
    @NotNull(message = "The email can't be null")  // Validación: el email no puede ser nulo
    @Email(message = "The email can't be null")
    private String email;

}
