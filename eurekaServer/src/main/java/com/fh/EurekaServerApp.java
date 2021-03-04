package com.fh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication//声明springboot启动类
@EnableEurekaServer //声明是eureka服务端
public class EurekaServerApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaServerApp.class,args);
    }
}
