package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.ShapeHand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad JPA que representa una jugada de piedra-papel-tijera (RPS) en la base de datos.
 * Está mapeada a la tabla "plays_rps".
 */
@Entity  // Indica que esta clase es una entidad JPA y está mapeada a una tabla en la base de datos
@Table(name = "plays_rps")  // Especifica el nombre de la tabla en la base de datos
@Data  // Genera automáticamente getters, setters, toString, equals, hashCode
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
public class PlayRpsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_rps_id")
    private MatchRpsEntity matchRps;

    @Enumerated(EnumType.STRING)
    private ShapeHand shapeHandPlayer1;

    @Enumerated(EnumType.STRING)
    private ShapeHand shapeHandPlayer2;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private PlayerEntity winner;
}
