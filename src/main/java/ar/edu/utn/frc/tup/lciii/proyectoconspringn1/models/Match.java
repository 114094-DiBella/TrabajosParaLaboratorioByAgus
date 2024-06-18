package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.MatchRps;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * Clase abstracta que representa un partido (match) en el sistema.
 * Contiene información básica común a todos los tipos de partidos.
 * Esta clase es abstracta y debe ser extendida por clases concretas que definen tipos específicos de partidos.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MatchRps.class)
})
@Data  // Genera automáticamente getters, setters, toString, equals, hashCode
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
public abstract class Match {

    private Long id;
    private Game game;
    private Player player1;
    private Player player2;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime updatedAt;

    private MatchStatus status;
   }
