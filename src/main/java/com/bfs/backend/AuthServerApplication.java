package com.bfs.backend;

import com.bfs.backend.config.HibernateConfig;
import com.bfs.backend.domain.UserInternalPersonnel;
import com.bfs.backend.service.UserInternalPersonnelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class AuthServerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(AuthServerApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        UserInternalPersonnelService userInternalPersonnelService = context.getBean(UserInternalPersonnelService.class);
        UserInternalPersonnel userInternalPersonnel= userInternalPersonnelService.getUserTest();
        System.out.println(userInternalPersonnel.getFirstName());
        System.out.println(userInternalPersonnel.getUserName());
    }

}
