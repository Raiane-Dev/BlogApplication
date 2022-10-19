package com.application.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

@Controller
public class FrontController
{
    @RequestMapping( "/" )
    public String index( ModelMap model )
    {
        model.addAttribute( "title", "Home" );
        
        return "index";
    }
}
