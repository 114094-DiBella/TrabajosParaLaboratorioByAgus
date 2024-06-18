package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.play;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.models.rps.MatchRps;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
 * Interfaz base para las solicitudes de jugada (PlayRequest).
 * Utiliza anotaciones de Jackson para la serialización/deserialización polimórfica.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION) // Configura Jackson para deducir el tipo de la instancia durante la deserializació
@JsonSubTypes({
        @JsonSubTypes.Type(value = PlayRpsDTO.class) // Define subtipos concretos que pueden implementar esta interfaz
})
public interface PlayRequest {

}
