package spring.io.springboot.exercises;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import spring.io.springboot.dev.dependencyinjection.constructor.SpringApp;

import java.util.Arrays;


public class SpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);
        System.out.println(Arrays.stream(context.getBean(BusinessCalcService.class).findMax()).max().orElse(0));
    }

    @Bean
    public DataService mysqlDataService() {
        return new MysqlDataService();
    }

    @Bean
    @Primary
    public DataService mongoDBDataService() {
        return new MongoDBDataService();
    }

    @Bean
    public BusinessCalcService service() {
        return new BusinessCalcService(mysqlDataService());
    }
}
