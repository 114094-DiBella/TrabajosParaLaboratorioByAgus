package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) utilizado para manejar las credenciales de autenticación de usuarios.
 * Contiene la identidad del usuario (username o email) y la contraseña.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credential {

    private Identity identity;
    private String password;
}
