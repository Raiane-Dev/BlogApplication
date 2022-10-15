package com.application.blog.daos;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.application.blog.daos.interfaces.ArticleInterface;
import com.application.blog.models.Article;
import com.application.blog.models.mappers.ArticleMapper;;


@Component
@Repository
public class ArticleDAO implements ArticleInterface
{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_ARTICLE = "SELECT * FROM articles WHERE id = ?";
    private final String SQL_GET_ALL = "SELECT * FROM articles";
    private final String SQL_DELETE_ARTICLE = "DELETE FROM articles WHERE id = ?";
    private final String SQL_UPDATE_ARTICLE = "UPDATE articles SET title = ?, body = ?, author = ?, created_date = ? WHERE id = ?";
    private final String SQL_INSERT_ARTICLE = "INSERT INTO articles(title, body, author, created_date) VALUES(?,?,?,?)";

    @Autowired
    public ArticleDAO( DataSource data )
    {
        jdbcTemplate = new JdbcTemplate(data);
    }

    public Article getArticleById( Long id )
    {
        return jdbcTemplate.queryForObject( SQL_FIND_ARTICLE, new ArticleMapper() );
    }

    public List<Article> getAllArticles()
    {
        return jdbcTemplate.query( SQL_GET_ALL, new ArticleMapper() );
    }

    public boolean deleteArticle( Article article )
    {
        return jdbcTemplate.update(
            SQL_DELETE_ARTICLE,
            article.getId() 
        ) > 0;
    }

    public boolean updateArticle( Long id, Article article )
    {
        return jdbcTemplate.update( 
            SQL_UPDATE_ARTICLE, 
            article.getTitle(),
            article.getBody(),
            article.getAuthor(),
            article.getCreatedDate(),
            id
        ) > 0;
    }

    public boolean createArticle( Article article )
    {
        return jdbcTemplate.update(
            SQL_INSERT_ARTICLE,
            article.getTitle(),
            article.getBody(),
            article.getAuthor(),
            article.getCreatedDate()
        ) > 0;
    }
}