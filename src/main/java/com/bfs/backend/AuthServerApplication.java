package com.bfs.backend;


import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.domain.RecruitingTesting;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.HomeCandidateService;
import com.bfs.backend.service.UserService;
import com.bfs.backend.config.HibernateConfig;
import com.bfs.backend.domain.UserInternalPersonnel;
import com.bfs.backend.service.UserInternalPersonnelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.util.List;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class AuthServerApplication {


//    public static void main(String[] args) throws ParseException {
//        SpringApplication.run(AuthServerApplication.class, args);

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(AuthServerApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        UserInternalPersonnelService userInternalPersonnelService = context.getBean(UserInternalPersonnelService.class);
        UserInternalPersonnel userInternalPersonnel= userInternalPersonnelService.getUserTest();
        System.out.println(userInternalPersonnel.getFirstName());
        System.out.println(userInternalPersonnel.getUserName());
        System.out.println(userInternalPersonnel.getRoleName());
        System.out.println(userInternalPersonnel.getDescription());

        RecruitingTesting recruitingTesting = userInternalPersonnelService.getRecruiting();
        System.out.println(recruitingTesting.getPositionName());
        System.out.println(recruitingTesting.getInterviewTypeDescription());
        System.out.println(recruitingTesting.getEmailSubject());
        System.out.println(recruitingTesting.getEmail());
        System.out.println(recruitingTesting.getSendDescription());

//        HomeCandidateService homeCandidateService=context.getBean(HomeCandidateService.class);
//        List<homeCandidate> hc = homeCandidateService.getHomeCandidate(1);
//        for(homeCandidate item : hc){
//            System.out.println(item.getFirstName());
//            System.out.println(item.getLastName());
//            System.out.println(item.getInterviewStartDateTime());
//            System.out.println(item.getPositionName());
//            System.out.println(item.getInterviewDuration());
//        }
    }

}
