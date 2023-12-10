package spring.io.springboot.dev.cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@Component
@Named
class BusinessService {
    private DataService service;

    public DataService getService() {
        return service;
    }

    //@Autowired
    @Inject
    public void setService(DataService service) {
        this.service = service;
    }
}

//@Component
@Named
class DataService {

}


@ComponentScan
public class CDIContextApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDIContextApp.class);
        System.out.println(context.getBean(BusinessService.class).getService());
    }
}
