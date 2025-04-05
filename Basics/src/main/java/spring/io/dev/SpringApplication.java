package spring.io.dev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.io.dev.config.ConfigProvider;
import spring.io.dev.game.GameRunner;

import java.util.Arrays;

@ComponentScan("spring.io.dev.game")
public class SpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigProvider.class);
        /*
        * context.getBean("methodName")
        * context.getBean("yourClass.class)
        *
        * */
        //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
       context.getBean(GameRunner.class).run();

    }
}
