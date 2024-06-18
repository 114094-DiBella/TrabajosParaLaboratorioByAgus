package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entidad JPA que representa un juego en la base de datos.
 * La tabla correspondiente en la base de datos se especifica con @Table(name = "games").
 */
@Entity  // Indica que esta clase es una entidad JPA y está mapeada a una tabla en la base de datos
@Table(name = "games")  // Especifica el nombre de la tabla en la base de datos
@Data  // Genera automáticamente getters, setters, toString, equals, hashCode
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
public class GameEntity {
    @Id  // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generación automática de valores para la clave primaria
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Lob
    @Column
    private String description;

    @Lob // Indica que este campo se mapea como un tipo CLOB (Character Large Object) en la base de datos
    @Column
    private  String rules;
}
