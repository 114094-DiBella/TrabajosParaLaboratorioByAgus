package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.utils.validations.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;
/**
 * Validador de contraseña personalizado que implementa ConstraintValidator para la anotación ValidPassword.
 * Utiliza la biblioteca Passay para aplicar reglas de validación a las contraseñas.
 */
public class PasswordConstraintValidator implements ConstraintValidator <ValidPassword, String> {

    @Override
    public void initialize(ValidPassword arg0){
        // Método de inicialización, no se requiere lógica específica para esta implementación

    }

    /**
     * Método principal que verifica si una contraseña cumple con las reglas de validación definidas.
     *
     * @param password                    la contraseña a validar
     * @param constraintValidatorContext  contexto proporcionado por el framework de validación
     * @return true si la contraseña es válida según las reglas, false si no lo es
     */
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8,30),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),
                new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));
        if(result.isValid()){
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(
                String.join(",",validator.getMessages(result)))
                .addConstraintViolation();
        return false;
    }
}
