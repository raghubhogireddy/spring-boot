package io.spring.restfulwebservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.spring.restfulwebservice.model.filtering.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {


    @GetMapping("/filters")
    public SomeBean getBeanFields() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filters/applied/static")
    public SomeBean getBeanFieldsWithFilterApplied() {
        return new SomeBean("value4", "value5", "value6");
    }

    @GetMapping("/filters/applied/dynamic")
    public MappingJacksonValue getBeanFieldsWithDynamicFilters() {
        SomeBean someBean = new SomeBean("value7", "value8", "value9");
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filterProvider);
        return mapping;
    }
}
