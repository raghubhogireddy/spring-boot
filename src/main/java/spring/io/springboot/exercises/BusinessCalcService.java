package spring.io.springboot.exercises;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;


interface DataService {
    int[] retrieveData();
}

class MongoDBDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}

class MysqlDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] {44, 47, 32, 23, 56};
    }
}





@Component // annotation doesn't matter if we are creating a instance from @Bean annotated method
public class BusinessCalcService {

    private DataService service;

    public BusinessCalcService(DataService service) {
        this.service = service;
    }

    public int[] findMax() {
        return service.retrieveData();
    }
}
