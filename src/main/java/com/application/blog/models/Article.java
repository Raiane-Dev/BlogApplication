package com.application.blog.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Article
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonProperty("author")
    private String author;

    @JsonProperty("created_date")
    private Date created_date; 

    public Article()
    {

    }

    public Article( Long id, String title, String body, String author )
    {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getBody()
    {
        return this.body;
    }

    public void setBody( String body )
    {
        this.body = body;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public void setAuthor( String author )
    {
        this.author = author;
    }

    public Date getCreatedDate()
    {
        return this.created_date;
    }

    public void setCreatedDate( Date created_date )
    {
        this.created_date = created_date;
    }
}