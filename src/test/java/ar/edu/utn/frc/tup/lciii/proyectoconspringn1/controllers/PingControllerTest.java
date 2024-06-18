package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void pingTest() throws Exception {
        // Realiza una solicitud GET a /ping y verifica la respuesta
        this.mockMvc.perform(get("/ping"))
                .andDo(print())  // Imprime el resultado de la solicitud por consola
                .andExpect(status().isOk())  // Verifica que el código de estado sea 200 (OK)
                .andExpect(content().string(containsString("pong")));  // Verifica que el cuerpo de la respuesta contenga "pong"
    }
}
