package spring.io.dev.lazyinitilaization;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA  classA;

    public ClassB(ClassA classA) {
        System.out.println("ClassB constructor initialization logic!!");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("ClassB method invoked!!");
    }
}

@ComponentScan
public class LazyInitializationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyInitializationApp.class);
        System.out.println("context Initialization completed");
        context.getBean(ClassB.class).doSomething();
    }
}
