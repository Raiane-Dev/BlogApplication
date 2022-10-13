package com.application.blog.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UserController
{
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public void user()
    {

    }

}