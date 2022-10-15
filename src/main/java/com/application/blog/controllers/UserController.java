package com.application.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.blog.models.User;
import com.application.blog.daos.interfaces.UserInterface;

@RestController
public class UserController 
{
    private final UserInterface userInterfaceDAO;

    public UserController( UserInterface userInterfaceDAO )
    {
        this.userInterfaceDAO = userInterfaceDAO;
    }

    @GetMapping( value= "/users")
    public List<User> hasMany()
    {
        return userInterfaceDAO.getAllUsers();
    }
    
    @GetMapping( value="/users/{name}" )
    public String article( @PathVariable("title") String name )
    {
        return name;
    }

    @PostMapping(value = "/users")
    public void create( @Validated @RequestBody User body )
    {
        userInterfaceDAO.createUser(body);
    }

    @PutMapping( value="/users/{id}" )
    public boolean update( @Validated @RequestBody User user, @PathVariable("id") int id)
    {
        return userInterfaceDAO.updateUser(id, user);
    }
    
}
