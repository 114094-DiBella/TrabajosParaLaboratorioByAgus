package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * Clase que representa un juego en el sistema.
 * Contiene información básica sobre un juego, como su código, nombre, descripción y reglas.
 */
@Data  // Genera automáticamente getters, setters, toString, equals, hashCode
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
public class Game {
   private Long id;
    private String code;
    private String name;
    private String description;
    private  String rules;
}
