package com.application.blog.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.application.blog.daos.interfaces.UserInterface;
import com.application.blog.models.User;
import com.application.blog.models.mappers.UserMapper;

@Component
@Repository
public class UserDAO implements UserInterface
{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_USER = "SELECT * FROM USERS WHERE ID = ?";
    private final String SQL_GET_ALL = "SELECT * FROM USERS";
    private final String SQL_DELETE_USER = "DELETE FROM USERS WHERE ID = ?";
    private final String SQL_UPDATE_USER = "UPDATE users SET name = ?, age = ?, email = ?, password = ? WHERE id = ?";
    private final String SQL_INSERT_USER = "INSERT INTO USERS(name, age, email, password) VALUES(?, ?, ?, ?, ?)";

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

    public boolean updateUser( Integer id, User user )
    {
        return jdbcTemplate.update(SQL_UPDATE_USER, user.getName(), user.getAge(), user.getEmail(), user.getPassword(), id ) > 0;
    }

    public boolean createUser( User user )
    {
        return jdbcTemplate.update(SQL_INSERT_USER, user.getName(), user.getAge(), user.getEmail(), user.getPassword() ) > 0;
    }
}