package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities;


import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Game;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.MatchStatus;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidad JPA que representa un partido (match) en la base de datos.
 * La tabla correspondiente en la base de datos se especifica con @Table(name = "matches").
 */
@Entity  // Indica que esta clase es una entidad JPA y está mapeada a una tabla en la base de datos
@Table(name = "matches")  // Especifica el nombre de la tabla en la base de datos
@Data  // Genera automáticamente getters, setters, toString, equals, hashCode
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "match_type", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
public class MatchEntity {
    @Id  // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generación automática de valores para la clave primaria
    private Long id;

    @JoinColumn(name = "game_id")
    @ManyToOne
    private GameEntity game;

    @JoinColumn(name = "player1_id")
    @ManyToOne
    private PlayerEntity player1;

    @JoinColumn(name = "player2_id")
    @ManyToOne
    private PlayerEntity player2;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updateAt;

    @Column
    @Enumerated(EnumType.STRING)
    private MatchStatus status;
}
