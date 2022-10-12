package com.application.blog.models;

public class User {
    
    private Long id;
    private Integer age;
    private String name;
    private String email;
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
