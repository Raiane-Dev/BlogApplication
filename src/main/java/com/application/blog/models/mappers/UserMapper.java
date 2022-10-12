package com.application.blog.models.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.application.blog.models.User;

public class UserMapper implements RowMapper<User>
{
    public User mapRow( ResultSet resultSet, int i ) throws SQLException
    {
        User user = new User();
        user.setId( resultSet.getLong("id") );
        user.setAge( resultSet.getInt("age") );
        user.setName( resultSet.getString("name") );
        user.setEmail( resultSet.getString("email") );
        user.setPassword( resultSet.getString("password") );

        return user;
    }    
}
