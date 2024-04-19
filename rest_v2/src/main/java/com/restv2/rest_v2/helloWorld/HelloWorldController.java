package com.restv2.rest_v2.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
//Controller
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;



//    get method and use URI -> /hello-world <- method HelloWorld

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "hello-world")
    public String helloWorld(){
        return "Hello World - You";
    }

//    get(/customer)
    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World - You");
    }

    // take the variable from url - get( root/customer/{id} )
    @GetMapping(path = "hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("%s,  Given variable", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloInternational(){
//        when parameter
//        @RequestHeader(name = "Accept-Language", required = false) Locale locale
//         is passed use below
//        return messageSource.getMessage("good.morning.message", null, locale);
        return messageSource.getMessage("good.morning.message ", null,
                LocaleContextHolder.getLocale());
    }
}
