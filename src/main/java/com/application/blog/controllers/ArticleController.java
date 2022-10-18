package com.application.blog.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.blog.models.Article;
import com.application.blog.daos.interfaces.ArticleInterface;


@RestController
public class ArticleController
{
    private final ArticleInterface articleInterfaceDAO;

    public ArticleController( ArticleInterface articleInterfaceDAO )
    {
        this.articleInterfaceDAO = articleInterfaceDAO;
    }

    @GetMapping( value = "/articles" )
    public List<Article> hasMany()
    {
        return articleInterfaceDAO.getAllArticles();
    }

    @GetMapping( value = "/article/{title}" )
    public String article( @PathVariable("title") String title )
    {
        return title;
    }

    @PostMapping( value = "/articles" )
    public void create( @Validated @RequestBody Article body )
    {
        articleInterfaceDAO.createArticle(body);
    }

    @PutMapping( value = "/article/{id}" )
    public boolean update( @Validated @RequestBody Article article, @PathVariable("id") Long id )
    {
        return articleInterfaceDAO.updateArticle(id, article);
    }
}