package spring.io.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.io.springboot.config.ConfigProvider;
import spring.io.springboot.game.GameConsole;
import spring.io.springboot.game.GameRunner;
import spring.io.springboot.game.MarioGame;

import java.util.Arrays;

public class SpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigProvider.class);
        /*
        * context.getBean("methodName")
        * context.getBean("yourClass.class)
        *
        * */
       context.getBean(GameRunner.class).run();

    }
}
