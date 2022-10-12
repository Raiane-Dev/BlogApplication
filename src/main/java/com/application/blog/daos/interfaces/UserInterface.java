package com.application.blog.daos.interfaces;

import java.util.List;

import com.application.blog.models.User;

public interface UserInterface
{

    UserInterface getUserById( Long id );
    
    List<User> getAllUsers();
    
    boolean deleteUser( User user );

    boolean updateUser( User user );

    boolean createUser( User user );
}