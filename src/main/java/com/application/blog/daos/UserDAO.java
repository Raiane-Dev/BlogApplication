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

    private final String SQL_FIND_USER = "select * from users where id = ?";
    private final String SQL_GET_ALL = "select * from users";
    private final String SQL_DELETE_USER = "delete from users where id = ?";
    private final String SQL_UPDATE_USER = "update users set name = ?, age = ?, email = ?, password = ?";
    private final String SQL_INSERT_USER = "insert into users(id, name, age, email, password)";

    @Autowired
    public UserDAO(DataSource data)
    {
        jdbcTemplate = new JdbcTemplate(data);
    }

    public User getUserById( Long id )
    {
        return jdbcTemplate.queryForObject(SQL_FIND_USER, new UserMapper(), id);
    }
    
    public List<User> getAllUsers()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
    }
    
    public boolean deleteUser( User user )
    {
        return jdbcTemplate.update(SQL_DELETE_USER, user.getId()) > 0;
    }

    public boolean updateUser( User user )
    {
        return jdbcTemplate.update(SQL_UPDATE_USER, user.getName(), user.getAge(), user.getEmail(), user.getPassword() ) > 0;
    }

    public boolean createUser( User user )
    {
        return jdbcTemplate.update(SQL_INSERT_USER, user.getName(), user.getAge(), user.getEmail(), user.getPassword() ) > 0;
    }
}