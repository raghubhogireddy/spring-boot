package spring.io.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.io.springboot.config.ConfigProvider;
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
        MarioGame marioGame = context.getBean(MarioGame.class);
        GameRunner runner = new GameRunner(marioGame);
        runner.run();

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);



    }
}
