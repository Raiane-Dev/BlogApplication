package com.application.blog.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    public User()
    {

    }

    public User( Long id, Integer age, String name, String email, String password  )
    {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public Integer getAge()
    {
        return this.age;
    }

    public void setAge( Integer age )
    {
        this.age = age;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

}
