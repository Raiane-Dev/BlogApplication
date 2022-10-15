package com.application.blog.models.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.application.blog.models.Article;

public class ArticleMapper implements RowMapper<Article>
{
    public Article mapRow( ResultSet resultSet, int i ) throws SQLException
    {
        Article article = new Article();
        article.setId( resultSet.getLong("id") );
        article.setTitle( resultSet.getString("title") );
        article.setBody( resultSet.getString("body") );
        article.setAuthor( resultSet.getString("author") );
        article.setCreatedDate( resultSet.getDate("created_date") );

        return article;
    }
}