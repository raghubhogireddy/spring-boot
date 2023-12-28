package io.spring.restfulwebservice.controller;

import io.spring.restfulwebservice.model.version.Name;
import io.spring.restfulwebservice.model.version.PersonV1;
import io.spring.restfulwebservice.model.version.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/v1/person")
    public PersonV1 getDetailsV1() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping("/v2/person")
    public PersonV2 getDetailsV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getDetailsRequestParamV1() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getDetailsRequestParamV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getDetailsHeaderV1() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getDetailsHeaderV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getDetailsMIMEV1() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(path = "/person/accept", headers = "application/vnd.company.app-v2+json")
    public PersonV2 getDetailsMIMEV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }
}
