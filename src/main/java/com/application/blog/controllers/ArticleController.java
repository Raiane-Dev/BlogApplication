package com.application.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.blog.models.User;
import com.application.blog.daos.UserDAO;
import com.application.blog.config.Database;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RestController
public class ArticleController 
{
    public UserDAO user;

    public ArticleController()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Database.class);
        this.user = context.getBean(UserDAO.class);
    }
    
    @GetMapping( value="/article/{title}" )
    public String article( @PathVariable("title") String title )
    {
        return title;
    }

    @PostMapping( 
        value = "/articles",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void create( @RequestBody UserDAO body )
    {
        for (User p : user.getAllUsers()) {
			System.out.println(p);
		}
    }

    @PutMapping( value="/articles/{id}" )
    public boolean update( @PathVariable("id") Integer id, @RequestBody List<Map<String,Object>> body )
    {
        return true;
    }
    
}
