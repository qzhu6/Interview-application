package com.bfs.backend;

<<<<<<< HEAD
import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.service.UserService;
=======
import com.bfs.backend.config.HibernateConfig;
import com.bfs.backend.domain.UserInternalPersonnel;
import com.bfs.backend.service.UserInternalPersonnelService;
>>>>>>> 600e27be13b1252e3108851b175468c51facd22f
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class AuthServerApplication {

<<<<<<< HEAD
    public static void main(String[] args) throws ParseException {
        SpringApplication.run(AuthServerApplication.class, args);

=======
    public static void main(String[] args) {
//        SpringApplication.run(AuthServerApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        UserInternalPersonnelService userInternalPersonnelService = context.getBean(UserInternalPersonnelService.class);
        UserInternalPersonnel userInternalPersonnel= userInternalPersonnelService.getUserTest();
        System.out.println(userInternalPersonnel.getFirstName());
        System.out.println(userInternalPersonnel.getUserName());
>>>>>>> 600e27be13b1252e3108851b175468c51facd22f
    }

}
