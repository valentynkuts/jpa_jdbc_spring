package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        //JdbcTemplate jdbcTemplate = null;
        jdbcTemplate.execute("DROP TABLE auto IF EXISTS ");
        jdbcTemplate.execute("CREATE TABLE auto (id INT AUTO_INCREMENT  PRIMARY KEY, marka VARCHAR(255), registration VARCHAR(255))");
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
