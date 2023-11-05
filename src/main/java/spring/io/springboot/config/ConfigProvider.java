package spring.io.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.io.springboot.game.MarioGame;
import spring.io.springboot.game.PacManGame;

@Configuration
public class ConfigProvider {
    //Configure things that we want Spring to manage

    @Bean(name = "mario") // you can make Spring Context to modify default bean name by using 'name' attribute
    public MarioGame marioGame() {
        return new MarioGame();
    }

    @Bean
    public PacManGame pacManGame(MarioGame marioGame) { // you can reuse existing beans as part of new bean creation
        return new PacManGame();
    }
}
