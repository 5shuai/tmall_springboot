package com.how2j.tmall_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

/**
 * @author wuss
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
