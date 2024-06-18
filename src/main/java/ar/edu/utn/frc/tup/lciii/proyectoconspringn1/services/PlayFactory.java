package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.play.PlayRequest;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.play.PlayRpsDTO;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Play;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.PlayRps;

public class PlayFactory {

    /**
     * Obtiene una instancia de Play según el tipo de juego especificado en gameCode.
     *
     * @param playRequest solicitud de jugada
     * @param gameCode    código del juego
     * @return una instancia de Play correspondiente al juego especificado
     */
    public static Play getPlayInstance(PlayRequest playRequest, String gameCode){
        switch (gameCode) {
            case "RPS":
                return getPlayRpsInstance(playRequest);
            default:
                return getPlayRpsInstance(playRequest);
        }
    }

    /**
     * Obtiene una instancia de PlayRps a partir de una solicitud de jugada PlayRpsDTO.
     *
     * @param playRequest solicitud de jugada específica para Rock-Paper-Scissors (RPS)
     * @return una instancia de PlayRps
     */
    private static Play getPlayRpsInstance(PlayRequest playRequest) {
        PlayRpsDTO playRpsDTO  = (PlayRpsDTO) playRequest;
        PlayRps playRps = new PlayRps();
        playRps.setShapeHandPlayer1(playRpsDTO.getShapeHandPlayer1());
        playRps.setShapeHandPlayer2(playRpsDTO.getShapeHandPlayer2());
        return playRps;
    }
}
