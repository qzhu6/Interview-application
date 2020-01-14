package com.bfs.backend;

import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.text.ParseException;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class AuthServerApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(AuthServerApplication.class, args);

    }

}
