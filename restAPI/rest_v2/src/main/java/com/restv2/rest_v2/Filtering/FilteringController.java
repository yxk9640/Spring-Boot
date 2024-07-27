package com.restv2.rest_v2.Filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveFilterBean(){
        FilterBean filterBean = new FilterBean("v1","v2","v3");

        SimpleBeanPropertyFilter filterOut12 = SimpleBeanPropertyFilter
                .filterOutAllExcept("filter1", "filter2");

        FilterProvider customFilter = new SimpleFilterProvider()
                .addFilter("BeanFilter", filterOut12);

        MappingJacksonValue mapping = new MappingJacksonValue(filterBean);
        mapping.setFilters(customFilter);

        return mapping;
    }


    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListofFilterBeans(){
        List<FilterBean> items = Arrays.asList(
                new FilterBean("v1","v2","v3"),
                new FilterBean("v11","v22","v33")
        );

        SimpleBeanPropertyFilter filterOut23 = SimpleBeanPropertyFilter
                .filterOutAllExcept("filter2","filter3");

        FilterProvider customFilter23 = new SimpleFilterProvider()
                .addFilter("BeanFilter", filterOut23);

        MappingJacksonValue mapItmers = new MappingJacksonValue(items);
        mapItmers.setFilters(customFilter23);

        return mapItmers;
    }

}
