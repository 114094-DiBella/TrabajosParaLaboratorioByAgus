package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.impl;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login.Identity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Match;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Player;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa.PlayerJpaRepository;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.MatchService;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
/**
 * Implementación del servicio PlayerService que maneja la lógica de negocio relacionada con jugadores.
 * Utiliza Spring para la inyección de dependencias y ModelMapper para mapeo de entidades a modelos y viceversa.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerJpaRepository playerJpaRepostory;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Obtiene un jugador por su ID.
     *
     * @param id el ID del jugador a buscar
     * @return el jugador encontrado como objeto Player
     * @throws EntityNotFoundException si no se encuentra el jugador con el ID especificado
     */
    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity = playerJpaRepostory.getReferenceById(id);
        if (Objects.isNull(playerEntity.getUserName())){
            throw new EntityNotFoundException();
        }
        Player player = modelMapper.map(playerEntity, Player.class);
        return player;
    }
    /**
     * Guarda un nuevo jugador.
     *
     * @param player el jugador a guardar
     * @return el jugador guardado como objeto Player si se guarda correctamente, o null si ya existe un jugador con el mismo username o email
     */
    @Override
    public Player savePlayer(Player player) {
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepostory.findByUserNameOrEmail(
                player.getUserName(), player.getEmail()
        );
        if (playerEntityOptional.isEmpty()) {
            PlayerEntity playerEntity = modelMapper.map(player, PlayerEntity.class);
            PlayerEntity playerEntitySave = playerJpaRepostory.save(playerEntity);
            return modelMapper.map(playerEntitySave, Player.class);
        } else {
            return null;
        }
    }
    /**
     * Obtiene un jugador por su nombre de usuario y contraseña.
     *
     * @param userName nombre de usuario del jugador
     * @param password contraseña del jugador
     * @return el jugador encontrado como objeto Player
     * @throws EntityNotFoundException si no se encuentra el jugador con el nombre de usuario y contraseña especificados
     */
    @Override
    public Player getPlayerByUserNameAndPassword(String userName, String password) {
        Optional<PlayerEntity> playerEntityOptional =playerJpaRepostory.findByUserNameAndPassword(userName,password);
        if(playerEntityOptional.isPresent())
        {
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }else {
            throw new EntityNotFoundException("Username or password invalid!");
        }
           }

    /**
     * Obtiene un jugador por su correo electrónico y contraseña.
     *
     * @param email    correo electrónico del jugador
     * @param password contraseña del jugador
     * @return el jugador encontrado como objeto Player
     * @throws EntityNotFoundException si no se encuentra el jugador con el correo electrónico y contraseña especificados
     */
    @Override
    public Player getPlayerByEmailAndPassword(String email, String password) {
        Optional<PlayerEntity> playerEntityOptional =playerJpaRepostory.findByEmailAndPassword(email,password);
        if(playerEntityOptional.isPresent())
        {
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }else {
            throw new EntityNotFoundException("Username or password invalid!");
        }
    }


    /**
     * Obtiene un jugador por su nombre de usuario o correo electrónico y contraseña.
     *
     * @param identity nombre de usuario o correo electrónico del jugador
     * @param password contraseña del jugador
     * @return el jugador encontrado como objeto Player
     * @throws EntityNotFoundException si no se encuentra el jugador con el nombre de usuario o correo electrónico y contraseña especificados
     */
    @Override
    public Player getPlayerByUserNameOrEmailAndPassword(String identity, String password) {
      Optional<PlayerEntity> playerEntityOptional = playerJpaRepostory.findByUserNameOrEmailAndPassword(identity, password);
        if(playerEntityOptional.isPresent())
        {
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }else {
            throw new EntityNotFoundException("Username or password invalid!");
        }
    }

   }

