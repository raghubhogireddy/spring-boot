package spring.io.springboot.dependencyinjection.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class Service {

    Dependency1 dependency1;
    Dependency2 dependency2;

    @Autowired
    public Service(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {
    public String toString() {
        return "Dependency1." + Dependency1.class.hashCode();
    }
}

@Component
class Dependency2 {
    public String toString() {
        return "Dependency2." + Dependency2.class.hashCode();
    }
}


@Configuration
@ComponentScan
public class SpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApp.class);
        System.out.println(context.getBean(Service.class));
    }
}
