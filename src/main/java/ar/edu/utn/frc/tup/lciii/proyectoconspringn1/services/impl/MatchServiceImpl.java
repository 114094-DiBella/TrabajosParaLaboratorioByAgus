package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.impl;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.match.MatchDTO;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.play.PlayRequest;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.*;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa.MatchEntityFactory;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.repositories.jpa.MatchJpaRepository;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.*;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchJpaRepository matchJpaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayStrategyFactory playStrategyFactory;

    /**
     * Obtiene todas las partidas de un jugador por su ID.
     *
     * @param playerId el ID del jugador
     * @return una lista de partidas del jugador
     */
    @Override
    public List<Match> getMatchesByPlayer(Long playerId) {
       List<Match> matches = new ArrayList<>();
        Optional<List<MatchEntity>> optionalMatchEntities = matchJpaRepository.findAllByPlayer1IdOrPlayer2Id(playerId,playerId);
        if(optionalMatchEntities.isPresent()){
            optionalMatchEntities.get().forEach(
                  me -> { matches.add(modelMapper.map(me, MatchFactory.getTypeOfMatch(me.getGame().getCode())));}
            );
//            for(MatchEntity me : optionalMatchEntities.get()){
//                matches.add(modelMapper.map(me,Match.class));
//            }

        }
        return matches;
    }

    /**
     * Crea una nueva partida basada en los datos proporcionados en el DTO de partida.
     *
     * @param matchDTO los datos de la partida a crear
     * @return la partida creada
     */
    @Override
    public Match createMatch(MatchDTO matchDTO) {

        Player player = playerService.getPlayerById(matchDTO.getPlayerId());
        Game game = gameService.getGame(matchDTO.getGameId());
        Match match = MatchFactory.createMatch(player,game);
        //MatchEntity matchEntity= matchJpaRepository.save(modelMapper.map(match,MatchEntity.class));
        MatchEntity matchEntity = matchJpaRepository.save(modelMapper.map(match, MatchEntityFactory.getTypeOfMatch(match)));
        return modelMapper.map(matchEntity, Match.class);
    }

    /**
     * Obtiene una partida por su ID.
     *
     * @param id el ID de la partida
     * @return la partida encontrada
     * @throws EntityNotFoundException si no se encuentra la partida
     */
    @Override
    public Match getMatchById(Long id) {
      MatchEntity me = (MatchEntity) Hibernate.unproxy(matchJpaRepository.getReferenceById(id));
       if(me != null){
            Match match = modelMapper.map(me, MatchFactory.getTypeOfMatch(me.getGame().getCode()));
            return match;
        }
        else {
            throw new EntityNotFoundException();
        }
    }
    /**
     * Realiza una jugada en una partida específica.
     *
     * @param id          el ID de la partida
     * @param playRequest los datos de la jugada a realizar
     * @return la jugada realizada
     * @throws EntityNotFoundException si no se encuentra la partida
     * @throws ResponseStatusException  si la partida no está en estado iniciado
     */

    @Transactional
    @Override
    public Play play(Long id, PlayRequest playRequest) {
        Match match = this.getMatchById(id);
        if(match == null)
        {
            throw new EntityNotFoundException();
        }
        if(match.getStatus() != MatchStatus.STARTED){
            throw  new ResponseStatusException(HttpStatus.CONFLICT, String.format("the match is %s", match.getStatus()));
        }
        Play play = PlayFactory.getPlayInstance(playRequest, match.getGame().getCode());
        PlayMatch playMatch = playStrategyFactory.getPlayStrategy(match.getGame().getCode());
        return playMatch.play(play, match);
    }
}
