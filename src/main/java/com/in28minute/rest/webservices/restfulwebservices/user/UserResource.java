package com.in28minute.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User find = userDaoService.findOne(id);
        if (find == null) {
            throw new UserNotFoundException(String.format("ID %s not found ", id));
        }
        EntityModel<User> model = EntityModel.of(find);
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        model.add(webMvcLinkBuilder.withRel("all-users"));
        return model;
    }


    //input details of user
    //output - CREATED and Return the created URI

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        // return status : CREATED
        // And it should return uri ;// users/4
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri() // don't want to hardcode /users/
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id) {
        User find = userDaoService.deleteById(id);
        if (find == null) {
            throw new UserNotFoundException(String.format("ID %s not found ", id));
        }
        return find;
    }
}
