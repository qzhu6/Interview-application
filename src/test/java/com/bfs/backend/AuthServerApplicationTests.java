package com.bfs.backend;

import com.bfs.backend.dao.*;
import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.domain.Employee;
import com.bfs.backend.domain.Position;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.responseDomain.myCandidate;
import com.bfs.backend.service.*;
import com.bfs.backend.service.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthServerApplicationTests {


    @Mock
    private PositionDAO positionDAO;
    @Mock
    private myCandidateDAO myCandidateDAO;
    @Mock
    private EmailTemplateDAO emailTemplateDAO;
    @Mock
    private SendEmailService sendingEmailService;
    @Mock
    private CandidateDAO candidateDAO;
    @Mock
    private EmployeeDAO employeeDAO;
    @Mock
    private EmailDAO emailDAO;



    @InjectMocks
    private PositionService positionService = new PositionServiceImpl();
    @InjectMocks
    private myCandidateService myCandidateService = new myCandidateServiceImpl();
    @InjectMocks
    private HomeCandidateService homeCandidateService = new HomeCandidateServiceImpl();
    @InjectMocks
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @InjectMocks
    private EmailTemplateService emailTemplateService = new EmailTemplateServiceImpl();
    @InjectMocks
    private EmailService emailService = new EmailServiceImpl();



//    @BeforeEach
//    void setUser() {
//        userInformation ui=new userInformation();
//        ui.setUserID(1);
//        ui.setPassword("aaa");
//        ui.setUsername("james");
//        when(userDAo.getUserByName("james")).thenReturn(ui);
//    }
    @BeforeEach
    void setPosition() {
        Position p= new Position();
        p.setPositionName("SQL");
        when(positionDAO.getPositionByName("SQL")).thenReturn(p);
    }
    @BeforeEach
    void setmyCandidate() {
        myCandidate mc= new myCandidate();
        mc.setID(1);
        List<myCandidate> mcl=new ArrayList<>();
        mcl.add(mc);
        when(myCandidateDAO.getMyCandidate(1)).thenReturn(mcl);
    }

    @Test
    void testEmail() {
        EmailTemplate et=new EmailTemplate();
        et.setEmailTemplateName("a");
        when(emailDAO.getEmailByName("a")).thenReturn(et);
        assertEquals(et, emailService.getEmailByName("a"));
    }
    @Test
    void testEmailService() {
        List<String> ls=new ArrayList<>();
        ls.add("a");
        EmailTemplate et=new EmailTemplate();
        et.setEmailTemplateName("a");
        List<EmailTemplate> let=new ArrayList<>();
        let.add(et);
        when(emailTemplateDAO.listStringEmailTemplateName()).thenReturn(ls);
        when(emailTemplateDAO.listEmailTemplate()).thenReturn(let);
        doNothing().when(emailTemplateDAO).createEmailTemplate(et,1);
        assertEquals("a", emailTemplateService.getEmailTemplateName().get(0));
        assertEquals("a", emailTemplateService.getEmailTemplateList().get(0).getEmailTemplateName());
        emailTemplateService.createEmailTemplate(et,1);

    }
    @Test
    void testEmployee() {
        Employee employee=new Employee();
        employee.setID(1);
        when(employeeDAO.getEmployeeByName("a","b")).thenReturn(employee);
        when(employeeDAO.getEmployeeByUserID(1)).thenReturn(employee);
        assertEquals(1, employeeService.getEmployeeByUserID(1).getID());
        assertEquals(1, employeeService.getEmployee("a","b").getID());
    }
    @Test
    void insertCandidate() {
        homeCandidate homeCandidate=new homeCandidate();
        homeCandidate.setFirstName("James");
        List<homeCandidate> lhc=new ArrayList<>();
        lhc.add(homeCandidate);
        when(candidateDAO.getHomeCandidate(1)).thenReturn(lhc);
        assertEquals("James", homeCandidateService.getHomeCandidate(1).get(0).getFirstName());
    }
//    @Test
//    void testUser() {
//        assertEquals("james", userService.getUserByName("james").getUsername());
//    }
    @Test
    void testPosition() {
        assertEquals("SQL", positionService.getPositionObject("SQL").getPositionName());
    }
    @Test
    void testmyCandidate() {
        assertEquals(1, myCandidateService.getMyCandidate(1).get(0).getID());
    }
    @Test
    void testupdatemyCandidate() {
        EmailTemplate emailTemplate=new EmailTemplate();
        myCandidate mc= new myCandidate();
        mc.setID(1);
        mc.setEmailTemplateName("a");
        mc.setFirstName("firstName");
        mc.setEmail("name");

        List<myCandidate> mcl=new ArrayList<>();
        mcl.add(mc);
        when(emailTemplateDAO.lookUpEmailTemplate("a")).thenReturn(emailTemplate);
        doNothing().when(sendingEmailService).sendEmailTemplate(emailTemplate,"name","firstName");
        doNothing().when(myCandidateDAO).updateCandidate(mc,emailTemplate);
        myCandidateService.updateCandidate(mcl);

    }




}
