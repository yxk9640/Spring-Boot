package com.restv2.rest_v2.Filtering;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public FilterBean retrieveFilterBean(){
        return new FilterBean("v1","v2","v3");
    }

}
