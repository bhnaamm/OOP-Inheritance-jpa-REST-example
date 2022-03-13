package com.bhnaamm.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * As it's going to be a RESTfull API, I suggest to design it from a resource-oriented perspective.
 * So, Cars are resources that can be persisted, updated, deleted, and fetched (functionalities can get also considered in the business layer).
 *
 * I assume, Authentication/Authorization is handled in a gateway or in an interceptor, somewhere else.
 *
*/

@SpringBootApplication
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
