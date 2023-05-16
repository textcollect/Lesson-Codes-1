package org.generation.fsdwebdemo.security;

//This Class will implement the WebMvcConfigurer interface provided by Spring Boot
// Framework
//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurer.html

//This Class is to perform action on URL Routing and mapping when a HTTP request comes in
//E.g. if user key in localhost:8080 in the browser, browser will send a HTTP GET
// request to the server (back-end). The back-end will need to handle which HTML to
// response back to the browser (client) - index.html

import org.springframework.beans.factory.annotation.Value;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Value("${image.folder}")
	private String imageFolder; //now imageFolder variable the value = productimages

	public void addViewControllers(ViewControllerRegistry registry) {
		//Map the browser's URL to a specific View (HTML) inside resources/templates directory
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/aboutus").setViewName("aboutus");
		registry.addViewController("/product").setViewName("product");
		registry.addViewController("/productForm").setViewName("productForm");

		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("index");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static")
				.addResourceLocations("classpath:/static/")
				.setCachePeriod(0);

		// image upload
		Path uploadDir = Paths.get(imageFolder);
		String uploadPath = uploadDir.toFile().getAbsolutePath();

		registry.addResourceHandler("/" + imageFolder + "/**")
				.addResourceLocations("file:" + uploadPath + "/")
				.setCachePeriod(0);
	}
}
