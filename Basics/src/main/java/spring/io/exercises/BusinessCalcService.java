package spring.io.exercises;


import org.springframework.stereotype.Component;


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
