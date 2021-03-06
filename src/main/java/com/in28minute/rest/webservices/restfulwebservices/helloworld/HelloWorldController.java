package com.in28minute.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //GET //Method
    //URI - /hello-world
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello-World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-varaible/{name}")
    public HelloWorldBean helloWorldWithPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, Hi %s", name));
    }

    @GetMapping(path = "/hello-world-i18n")
    public String helloWorldInternationalized(
//            @RequestHeader(name = "Accept-language", required = false) Locale locale //// to give locale in method is not good
    ) {

//        return "Hello-World-I18n";
        return messageSource.getMessage("good.morning.message", null, "Default Message",
                LocaleContextHolder.getLocale());
        //fr - bonjoure
        //nl - Goede Morgen
    }
}
