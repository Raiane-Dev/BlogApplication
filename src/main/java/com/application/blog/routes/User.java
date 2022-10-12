package com.application.blog.routes;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class User
{
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user()
    {
        return "oi";
    }

    @RequestMapping( value="/article/{name}", method = RequestMethod.GET)
    public void article( @PathVariable("name") String name )
    {

    }
}