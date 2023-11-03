package spring.io.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.io.springboot.game.Game;
import spring.io.springboot.game.MarioGame;

@Configuration
public class ConfigProvider {
    //Configure things that we want Spring to manage

    @Bean
    public MarioGame marioGame() {
        return new MarioGame();
    }
}
