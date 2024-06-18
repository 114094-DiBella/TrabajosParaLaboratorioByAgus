package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidad JPA que representa un partido de piedra-papel-tijera (RPS) en la base de datos.
 * Extiende de MatchEntity y está mapeada a la tabla "matches_rps".
 */

@Entity  // Indica que esta clase es una entidad JPA y está mapeada a una tabla en la base de datos
//@DiscriminatorValue("RPS")  // Especifica el nombre de la tabla en la base de datos
@Table(name = "matches_rps")
@Data  // Genera automáticamente getters, setters, toString, equals, hashCode
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
public class MatchRpsEntity extends MatchEntity{

    private Long id;
    private Integer numberOfPlays;
    private Integer remainderPlays;
    private Integer player1Score;
    private Integer player2Score;

    @OneToMany(mappedBy = "matchRps")
    private List<PlayRpsEntity> plays;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private PlayerEntity winner;

}
