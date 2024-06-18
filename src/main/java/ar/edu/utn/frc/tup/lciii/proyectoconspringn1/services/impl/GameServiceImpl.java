package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.impl;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.GameEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Game;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa.GameJpaRepository;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameJpaRepository gameJpaRepository;
    @Autowired
    private ModelMapper modelMapper;
    /**
     * Obtiene un juego por su identificador.
     *
     * @param gameId el ID del juego a buscar
     * @return el juego encontrado o null si no existe
     */
    @Override
    public Game getGame(Long gameId) {
        GameEntity gameEntity = gameJpaRepository.getReferenceById(gameId);

        return modelMapper.map(gameEntity, Game.class);
    }
}
