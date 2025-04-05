package spring.io.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.io.dev.game.*;

@Configuration
@ComponentScan("spring.io.springboot.dev.game")
public class ConfigProvider {
    //Configure things that we want Spring to manage

    @Bean(name = "mario") // you can make Spring Context to modify default bean name by using 'name' attribute
    public MarioGame marioGame() {
        return new MarioGame();
    }

    @Bean(name = "game")
    public PacManGame pacManGame() { // you can reuse existing beans as part of new bean creation
        return new PacManGame();
    }

    @Bean
    //@Primary
    public ContraGame contraGame() {
        return new ContraGame();
    }

    @Bean
    public GameRunner runner() {
        return new GameRunner(contraGame());
    }
}
