package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO (Data Transfer Object) utilizado para manejar el tipo de identidad de un usuario al iniciar sesión.
 * Utiliza anotaciones de Jackson para serialización/deserialización y anotaciones de Swagger para documentación.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "identity_type", include =
                JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserNameIdentity.class, name = "USERNAME"),
        @JsonSubTypes.Type(value = EmailIdentity.class, name = "EMAIL"),
})
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Identity {

    @Schema(title = "Type of identity used to logged in",
           description = "The Type of identity provided to logged in",
           example = "USERNAME or EMAIL",
           nullable = false)
    @NotNull(message = "identity_type can't by null")
    @JsonProperty("identity_type")
    private IdentityType identityType;
}
