package com.application.blog.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.application.blog.daos.interfaces.UserInterface;
import com.application.blog.models.User;
import com.application.blog.models.mappers.UserMapper;

@Component
public class UserDAO implements UserInterface
{
    JdbcTemplate jdbcTemplate;

    
}