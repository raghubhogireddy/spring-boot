package spring.io.springboot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import spring.io.springboot.game.*;

@Configuration
@ComponentScan("spring.io.springboot.game")
public class ConfigProvider {
    //Configure things that we want Spring to manage

//    @Bean(name = "mario") // you can make Spring Context to modify default bean name by using 'name' attribute
//    public MarioGame marioGame() {
//        return new MarioGame();
//    }

//    @Bean
//    public PacManGame pacManGame() { // you can reuse existing beans as part of new bean creation
//        return new PacManGame();
//    }
//
//    @Bean
//    public ContraGame contraGame() {
//        return new ContraGame();
//    }

//    @Bean
//    public GameRunner runner(GameConsole game) {
//        return new GameRunner(game);
//    }
}
