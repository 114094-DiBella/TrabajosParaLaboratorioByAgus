package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.utils.validations.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
        * Anotación de validación para validar contraseñas utilizando la clase ValidPasswordConstraintValidator.
        * Esta anotación se aplica a campos de tipo String y clases para verificar si cumplen con las reglas de validación especificadas.
 */
@Documented  // Hace que esta anotación aparezca en la documentación generada
@Constraint(validatedBy = PasswordConstraintValidator.class)  // Especifica la clase que implementa la lógica de validación
@Target({TYPE, FIELD, ANNOTATION_TYPE})  // Define dónde se puede aplicar esta anotación (campos, clases, otras anotaciones)
@Retention(RetentionPolicy.RUNTIME)  // Especifica cuándo se aplica esta anotación (en tiempo de ejecución)

 public @interface ValidPassword {

    String message() default "Invalid password";  // Mensaje por defecto si la validación falla
    Class<?>[] groups() default {};  // Grupos de restricciones que se aplican a esta anotación (no se usa en este caso)
    Class<? extends Payload>[] payload() default {};  // Información adicional sobre la anotación (no se usa en este caso)
}
