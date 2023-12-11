package spring.io.dev.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLConfigurationApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ContextConfiguration.xml");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean("name"));
    }
}
