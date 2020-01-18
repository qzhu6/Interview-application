package com.bfs.backend;


import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.domain.RecruitingTesting;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.AllCandidateService;
import com.bfs.backend.service.HomeCandidateService;
import com.bfs.backend.dao.PositionDAO;
import com.bfs.backend.domain.*;
import com.bfs.backend.responseDomain.Interview;
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

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class AuthServerApplication {


//    public static void main(String[] args) throws ParseException {
//        SpringApplication.run(AuthServerApplication.class, args);


    public static void main(String[] args) throws ParseException {
        SpringApplication.run(AuthServerApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        EmailService ac=context.getBean(EmailService.class);
//        System.out.println(ac.getEmailByName("BackEnd2").getID());

//        List<Integer> Id = new ArrayList<Integer>();
//        Id.add(1);
//        Id.add(2);
//        Id.add(3);
//        Id.add(4);
//        ac.UpdateEmployeeID(3,Id);

//        UserInternalPersonnelService userInternalPersonnelService = context.getBean(UserInternalPersonnelService.class);
//        UserInternalPersonnel userInternalPersonnel= userInternalPersonnelService.getUserTest();
//        System.out.println(userInternalPersonnel.getFirstName());
//        System.out.println(userInternalPersonnel.getUserName());
//        System.out.println(userInternalPersonnel.getRoleName());
//        System.out.println(userInternalPersonnel.getDescription());
//
//        RecruitingTesting recruitingTesting = userInternalPersonnelService.getRecruiting();
//        System.out.println(recruitingTesting.getPositionName());
//        System.out.println(recruitingTesting.getInterviewTypeDescription());
//        System.out.println(recruitingTesting.getEmailSubject());
//        System.out.println(recruitingTesting.getEmail());
//        System.out.println(recruitingTesting.getSendDescription());

//        HomeCandidateService homeCandidateService=context.getBean(HomeCandidateService.class);
//        List<homeCandidate> hc = homeCandidateService.getHomeCandidate(4);
//        for(homeCandidate item : hc){
//            System.out.println(item.getFirstName());
//            System.out.println(item.getLastName());
//            System.out.println(item.getCellPhone());
//            System.out.println(item.getInterviewerFirstName());
//            System.out.println(item.getInterviewerLastName());
//            System.out.println(item.getResumeFileLocation());
//            System.out.println(item.getInterviewStartDateTime());
//            System.out.println(item.getPositionName());
//            System.out.println(item.getInterviewDuration());
//    public static void main(String[] args) {
////        SpringApplication.run(AuthServerApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        PositionService positionService = context.getBean(PositionService.class);
//        InterviewTypeService interviewTypeService = context.getBean(InterviewTypeService.class);
//        EmployeeService employeeService = context.getBean(EmployeeService.class);
//        PotentialCandidateService potentialCandidateService = context.getBean(PotentialCandidateService.class);

//        Position positionObject = positionService.getPositionObject("BackEnd");
//        InterviewType interviewType = interviewTypeService.getInterviewType(positionObject, 1);
//        Employee employeeObject = employeeService.getEmployee("James", "Cui");
//        PotentialCandidate potentialCandidate = potentialCandidateService.getPotentialCandidate("Wes", "Zhu");
//        System.out.println(potentialCandidate.getID());
//        System.out.println(potentialCandidate.getEmail());
//        System.out.println(interviewType.getID());
//        System.out.println(interviewType.getInterviewTypeName());
//        System.out.println(interviewType.getInterviewTypeDescription());
//        System.out.println(employeeObject.getID());
//        System.out.println(employeeObject.getTitle());

//        System.out.println(interviewType.getInterviewTypeName());
//        System.out.println(interviewType.getInterviewTypeDescription());
//        System.out.println(interviewType.getSequence());


//        System.out.println(positionObject.getID());
//
//        InterviewService interviewService = context.getBean(InterviewService.class);
       Interview interview = new Interview(null, new Date(),2.0, "FrontEnd", "Bo", "Cui", null, "James", null, "Cui", null, "Testing resume hehe", 1, "Pending");
//        interviewService.createNewInterview(interview);
//        List<Interview> lInterview = interviewService.getListInterviewByPositionName("BackEnd");
//        for(Interview x: lInterview){
//            System.out.println(x.getID());
//            System.out.println(x.getPositionName());
//        }
//        List<Interview> interview = interviewService.getListInterview();
////        List<Interview> interview = interviewDao.getInterview();
//        Comparator<Interview> compareByName = Comparator.comparing(Interview::getIntervieweeFullName).thenComparing(Interview::getPositionName).thenComparing(Interview::getSequence);
//        List<Interview> sortedInterview = interview.stream().sorted(compareByName).collect(Collectors.toList());
//        List<List<Interview>> listBoCui = new ArrayList<List<Interview>>();
//        List<Interview> listNoBoCui = new ArrayList<Interview>();
//        for (int i = 0; i < sortedInterview.size(); i++) {
//            if (i == 0) {
//                listNoBoCui.add(sortedInterview.get(i));
//            } else if (i != 0) {
//                if (!sortedInterview.get(i).getIntervieweeFullName().equals(sortedInterview.get(i - 1).getIntervieweeFullName()) && !sortedInterview.get(i).getPositionName().equals(sortedInterview.get(i - 1).getPositionName())) {
//                    listBoCui.add(listNoBoCui);
//                    listNoBoCui = new ArrayList<Interview>();
//                    listNoBoCui.add(sortedInterview.get(i));
//                } else {
//                    listNoBoCui.add(sortedInterview.get(i));
//                }
//            }
//        }
//        listBoCui.add(listNoBoCui);
//        for(Interview inter: listBoCui.get(0)){
//            System.out.println("Interview ID: " + inter.getID());
//            System.out.println("Interview Status: " + inter.getInterviewStatus());
//            System.out.println("Interviewee: " + inter.getIntervieweeFullName());
////            System.out.println(inter.getInterviewerFirstName() + " " + inter.getInterviewerLastName());
//            System.out.println("Comment: " + inter.getComment());
//            System.out.println("Position Name: " + inter.getPositionName());
//            System.out.println("Sequence: " + inter.getSequence());
//            System.out.println("*************************************");
//        }
    }
}

//            System.out.println(inter.getID());
//            System.out.println(inter.getInterviewStatus());
//            System.out.println(inter.getIntervieweeFullName());
//            System.out.println(inter.getInterviewerFirstName() + " " + inter.getInterviewerLastName());
//            System.out.println(inter.getComment());
//            System.out.println(inter.getPositionName());
//            System.out.println(inter.getSequence());
//        }

//        UserInternalPersonnelService userInternalPersonnelService = context.getBean(UserInternalPersonnelService.class);
//        UserInternalPersonnel userInternalPersonnel= userInternalPersonnelService.getUserTest();
//        System.out.println(userInternalPersonnel.getFirstName());
//        System.out.println(userInternalPersonnel.getUserName());
//        System.out.println(userInternalPersonnel.getRoleName());
//        System.out.println(userInternalPersonnel.getDescription());
//
//        RecruitingTesting recruitingTesting = userInternalPersonnelService.getRecruiting();
//        System.out.println(recruitingTesting.getPositionName());
//        System.out.println(recruitingTesting.getInterviewTypeDescription());
//        System.out.println(recruitingTesting.getEmailSubject());
//        System.out.println(recruitingTesting.getEmail());
//        System.out.println(recruitingTesting.getSendDescription());

//    }

