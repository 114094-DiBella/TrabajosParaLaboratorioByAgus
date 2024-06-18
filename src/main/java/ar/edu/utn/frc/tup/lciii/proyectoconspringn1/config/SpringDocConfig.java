package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración para la documentación de API utilizando SpringDoc y OpenAPI.
 */
@Configuration
@Data
public class SpringDocConfig {

    // Valores inyectados desde application.properties o application.yml
    @Value("${app.url}")
    private String url;

    @Value("${app.dev-name}")
    private String devName;

    @Value("${app.dev-email}")
    private String devEmail;

    /**
     * Configura y provee un bean de OpenAPI.
     * OpenAPI se utiliza para generar la documentación de la API.
     *
     * @param appName el nombre de la aplicación
     * @param appDescription la descripción de la aplicación
     * @param appVersion la versión de la aplicación
     * @return una nueva instancia de OpenAPI configurada
     */
    @Bean
    public OpenAPI openApi(
            @Value("${app.name}") String appName,
            @Value("${app.desc}") String appDescription,
            @Value("${app.version}") String appVersion) {

        // Información de la API
        Info info = new Info()
                .title(appName)
                .version(appVersion)
                .description(appDescription)
                .contact(new Contact()
                        .name(devName)
                        .email(devEmail));

        // Información del servidor
        Server server = new Server()
                .url(url)
                .description(appDescription);

        // Configuración de OpenAPI
        return new OpenAPI()
                .components(new Components())
                .info(info)
                .addServersItem(server);
    }

    /**
     * Configura y provee un bean de ModelResolver.
     * ModelResolver se utiliza para la integración de Jackson con OpenAPI.
     *
     * @param objectMapper el ObjectMapper utilizado para serializar y deserializar objetos
     * @return una nueva instancia de ModelResolver configurada
     */
    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper) {
        return new ModelResolver(objectMapper);
    }
}
