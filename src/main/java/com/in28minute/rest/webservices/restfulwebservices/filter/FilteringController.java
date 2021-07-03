package com.in28minute.rest.webservices.restfulwebservices.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {


    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {

        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        String[] wantedFields = {"field1", "field2"};
        String filterId = "SomeBeanFilter";

        MappingJacksonValue mapping = getMappingJacksonValue(someBean, wantedFields, filterId);

        return mapping;
    }


    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean() {

        List<SomeBean> list = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("f1", "f2", "f3")
        );
        String[] wantedFields = {"field2"};
        String filterId = "SomeBeanFilter";

        return getMappingJacksonValue(list, wantedFields, filterId);
    }


    private MappingJacksonValue getMappingJacksonValue(Object object, String[] wantedFields, String filterId) {
        MappingJacksonValue mapping = new MappingJacksonValue(object);
        FilterProvider filters = getFilterProvider(wantedFields, filterId);
        mapping.setFilters(filters);
        return mapping;
    }

    private FilterProvider getFilterProvider(String[] wantedFields, String filterId) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(wantedFields);
        return new SimpleFilterProvider().addFilter(filterId, filter);
    }
}
