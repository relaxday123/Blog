package com.blog.post;

import com.blog.post.controller.AuthorController;
import net.bytebuddy.utility.FileSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication()
public class PostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
	}
}
