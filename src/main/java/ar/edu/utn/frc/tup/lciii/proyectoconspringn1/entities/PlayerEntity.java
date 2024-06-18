package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad JPA que representa a un jugador (player) en la base de datos.
 * Utiliza Lombok para generar automáticamente getters, setters, constructores y otros métodos.
 */
@Entity  // Indica que esta clase es una entidad JPA y está mapeada a una tabla en la base de datos
@Table(name = "players")  // Especifica el nombre de la tabla en la base de datos
@Data  // Genera automáticamente getters, setters, toString, equals, hashCode
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
public class PlayerEntity {

    @Id  // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generación automática de valores para la clave primaria
    private Long id;  // Identificador único del jugador

    @Column  // Indica que este campo está mapeado a una columna en la tabla
    private String userName;  // Nombre de usuario del jugador

    @Column  // Mapeado a una columna en la tabla
    private String password;  // Contraseña del jugador

    @Column  // Mapeado a una columna en la tabla
    private String email;  // Dirección de correo electrónico del jugador

    @Column  // Mapeado a una columna en la tabla
    private String avatar;  // URL o nombre de archivo del avatar del jugador

    @Column  // Mapeado a una columna en la tabla
    private LocalDateTime lastLogin;  // Fecha y hora del último inicio de sesión del jugador

    @Column(name = "created_at")  // Mapeado a una columna específica en la tabla
    private LocalDateTime createdAt;  // Fecha y hora de creación del registro

    @Column(name = "updated_at")  // Mapeado a una columna específica en la tabla
    private LocalDateTime updateAt;  // Fecha y hora de la última actualización del registro
}
