package spring.io.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.io.springboot.config.ConfigProvider;
import spring.io.springboot.game.GameRunner;
import spring.io.springboot.game.MarioGame;

public class SpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigProvider.class);
        MarioGame marioGame = (MarioGame) context.getBean("marioGame");
        GameRunner runner = new GameRunner(marioGame);
        runner.run();
    }
}
