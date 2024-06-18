package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de mapeadores para la aplicación.
 */
@Configuration
public class MappersConfig {

    /**
     * Configura y provee un bean de ModelMapper.
     * ModelMapper es una librería para la conversión de objetos.
     *
     * @return una nueva instancia de ModelMapper.
     */
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

    /**
     * Configura y provee un bean de ModelMapper con una condición personalizada.
     * Este mapper solo establecerá las propiedades que no sean nulas.
     *
     * @return una nueva instancia de ModelMapper con configuración de propiedades no nulas.
     */
    @Bean("mergerMapper")
    public ModelMapper mergerMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        return mapper;
    }

    /**
     * Configura y provee un bean de ObjectMapper.
     * ObjectMapper es una clase de Jackson para el mapeo de objetos Java a JSON y viceversa.
     * Se registra el módulo JavaTimeModule para soportar las clases de tiempo de Java 8.
     *
     * @return una nueva instancia de ObjectMapper con el módulo JavaTime registrado.
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
