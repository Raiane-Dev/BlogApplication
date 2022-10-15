package com.application.blog.daos.interfaces;

import java.util.List;
import com.application.blog.models.Article;

public interface ArticleInterface
{
    Article getArticleById( Long id );

    List<Article> getAllArticles();

    boolean createArticle( Article article );

    boolean deleteArticle( Article article );

    boolean updateArticle( Long id, Article article );
}