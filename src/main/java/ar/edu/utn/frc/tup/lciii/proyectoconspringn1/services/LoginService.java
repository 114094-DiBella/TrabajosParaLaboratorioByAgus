package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.Credential;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.CredentialV2;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Player;
import org.springframework.stereotype.Service;

/**
 * Interfaz que define los métodos para la autenticación y login de jugadores.
 *
 * Los métodos definidos en esta interfaz se utilizan para iniciar sesión de jugadores
 * utilizando diferentes tipos de credenciales.
 */
@Service
public interface LoginService {
    /**
     * Realiza el login de un jugador utilizando una Credential.
     *
     * @param credential las credenciales para el login (nombre de usuario o email y contraseña)
     * @return el jugador autenticado
     */
    Player login(Credential credential);


    /**
     * Realiza el login de un jugador utilizando una CredentialV2.
     *
     * @param credentialV2 las credenciales versión 2 para el login (nombre de usuario o email y contraseña)
     * @return el jugador autenticado
     */
    Player login(CredentialV2 credentialV2);
}
