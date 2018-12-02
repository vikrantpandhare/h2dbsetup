package com.example.h2client;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class H2DbClientApplication {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(H2DbClientApplication.class, args);
	}
	
	@PostConstruct
    private void initDb() {
        String sqlStatements[] = {
          "insert into student values(10003,'Vikrant', 'A1232143');"
        };
 
        Arrays.asList(sqlStatements).forEach(sql -> {
            jdbcTemplate.execute(sql);
        });
 
        // Fetch data using SELECT statement and print results
    } 
}
