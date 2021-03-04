package com.fh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserApp.class,args);
    }
}
