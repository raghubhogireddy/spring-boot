package spring.io.springboot.dev.prepost;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
class SomeClass {

    private SomeDependency dependency;

    public SomeClass(SomeDependency dependency) {
        System.out.println("Constructor initialization!");
        this.dependency = dependency;
    }

    @PostConstruct
    public void initialize() {
        dependency.getReady();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Resources getting freed!!");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Connections getting ready !!");
    }
}

@ComponentScan
public class PrePostSpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PrePostSpringApp.class);
        context.close(); // alternatively you can use try with resources, which automatically calls context.close()
    }
}
