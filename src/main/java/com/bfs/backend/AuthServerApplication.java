package com.bfs.backend;


import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.domain.RecruitingTesting;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.AllCandidateService;
import com.bfs.backend.service.HomeCandidateService;
import com.bfs.backend.dao.PositionDAO;
import com.bfs.backend.domain.*;
import com.bfs.backend.responseDomain.Interview;
import com.bfs.backend.responseDomain.myCandidate;
import com.bfs.backend.service.*;
import com.bfs.backend.config.HibernateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;

import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class AuthServerApplication {


    public static void main(String[] args) throws ParseException {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
