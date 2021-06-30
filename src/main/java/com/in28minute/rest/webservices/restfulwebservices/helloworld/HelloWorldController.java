package com.in28minute.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

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
}
