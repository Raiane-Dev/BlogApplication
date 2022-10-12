package com.application.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.application.blog.config.Database;
import com.application.blog.daos.UserDAO;
import com.application.blog.models.User;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( Database.class ); 

		UserDAO userDao = context.getBean(UserDAO.class);

		System.out.println("List of person is:");

		for (User p : userDao.getAllUsers()) {
			System.out.println(p);
		}


		SpringApplication.run(BlogApplication.class, args);
	}

}
