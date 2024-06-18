package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para representar un error API.
 * Utiliza Lombok para generar automáticamente los getters, setters, constructores y otros métodos.
 */
@Data  // Genera getters, setters, toString, equals, hashCode automáticamente
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera un constructor vacío
@Builder  // Patrón de diseño Builder para construir instancias de manera fluída
public class ErrorApi {

    private String timestamp;  // Marca de tiempo del error
    private Integer status;    // Código de estado HTTP del error
    private String error;      // Mensaje corto del error
    private String message;    // Descripción detallada del error
}
