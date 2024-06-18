package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.impl;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.Credential;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.CredentialV2;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.EmailIdentity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.UserNameIdentity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Player;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.LoginService;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PlayerService playerService;

    /**
     * Método de login que maneja la autenticación basada en el tipo de identidad proporcionada.
     *
     * @param credential las credenciales de acceso del jugador
     * @return el jugador autenticado si las credenciales son correctas, o null si no se encuentra o son incorrectas
     */

    @Override
    public Player login(Credential credential) {
        if(credential.getIdentity() instanceof UserNameIdentity){
            return loginWithIdentity((UserNameIdentity) credential.getIdentity(), credential.getPassword());
        }else {
        return loginWithIdentity((EmailIdentity) credential.getIdentity(), credential.getPassword());
        }
    }

    /**
     * Método de login que maneja la autenticación utilizando las credenciales v2 (identidad y contraseña).
     *
     * @param credentialV2 las credenciales de acceso del jugador
     * @return el jugador autenticado si las credenciales son correctas, o null si no se encuentra o son incorrectas
     */
    @Override
    public Player login(CredentialV2 credentialV2) {
       Player player = playerService.getPlayerByUserNameOrEmailAndPassword(credentialV2.getIdentity(), credentialV2.getPassword());
       return updateLastLogin(player);

    }

    /**
     * Realiza el login utilizando el nombre de usuario como identidad.
     *
     * @param identity el nombre de usuario del jugador
     * @param password la contraseña del jugador
     * @return el jugador autenticado si las credenciales son correctas, o null si no se encuentra o son incorrectas
     */
    private Player loginWithIdentity(UserNameIdentity identity, String password) {
        Player player =playerService.getPlayerByUserNameAndPassword(identity.getUserName(), password);
       return updateLastLogin(player);

    }
    /**
     * Realiza el login utilizando el correo electrónico como identidad.
     *
     * @param identity el correo electrónico del jugador
     * @param password la contraseña del jugador
     * @return el jugador autenticado si las credenciales son correctas, o null si no se encuentra o son incorrectas
     */
    private Player loginWithIdentity(EmailIdentity identity, String password) {
        Player player = playerService.getPlayerByEmailAndPassword(identity.getEmail(), password);
        return updateLastLogin(player);
   }

    /**
     * Actualiza la fecha y hora del último login del jugador.
     *
     * @param player el jugador para actualizar
     * @return el jugador actualizado
     */

    private Player updateLastLogin(Player player){
        player.setLastLogin(LocalDateTime.now());
        return playerService.savePlayer(player);
    }
}
