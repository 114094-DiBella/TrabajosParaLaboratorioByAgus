package ar.edu.utn.frc.tup.lciii.proyectoconspringn1;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.controllers.PingController;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.controllers.PlayerController;
import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private PlayerController playerController;
    @Autowired
    private PingController pingController;
    @Autowired
    private PlayerService playerService;

    @Test
    public void contexLoads() throws Exception{
        assertThat(playerController).isNotNull();
        assertThat(pingController).isNotNull();
        assertThat(playerService).isNotNull();
    }
}
