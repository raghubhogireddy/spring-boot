package spring.io.springboot.dev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.io.springboot.dev.config.ConfigProvider;
import spring.io.springboot.dev.game.GameRunner;

import java.util.Arrays;

@ComponentScan("spring.io.springboot.dev.game")
public class SpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);
        /*
        * context.getBean("methodName")
        * context.getBean("yourClass.class)
        *
        * */
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
       context.getBean(GameRunner.class).run();

    }
}
