package com.codenotfound.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import static javafx.application.Application.launch;


@SpringBootApplication
public class SpringKafkaApplication {

  public static void main(String[] args) {
//    SpringApplication.run(SpringKafkaApplication.class, args);
    SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringKafkaApplication.class);
    builder.headless(false);
    ConfigurableApplicationContext context = builder.run(args);


  }
}
