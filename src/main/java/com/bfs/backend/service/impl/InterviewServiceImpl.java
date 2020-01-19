package com.bfs.backend.service.impl;

import com.bfs.backend.dao.*;
import com.bfs.backend.domain.Employee;
import com.bfs.backend.domain.InterviewType;
import com.bfs.backend.domain.Position;
import com.bfs.backend.domain.PotentialCandidate;
import com.bfs.backend.responseDomain.Interview;
import com.bfs.backend.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    private InterviewDAO interviewDao;
    private PositionDAO positionDAO;
    private InterviewTypeDAO interviewTypeDAO;
    private EmployeeDAO employeeDAO;
    private PotentialCandidateDAO potentialCandidateDAO;

    @Autowired
    public void setPositionDAO(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    @Autowired
    public void setInterviewTypeDAO(InterviewTypeDAO interviewTypeDAO) {
        this.interviewTypeDAO = interviewTypeDAO;
    }

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Autowired
    public void setPotentialCandidate(PotentialCandidateDAO potentialCandidateDAO) {
        this.potentialCandidateDAO = potentialCandidateDAO;
    }

    @Autowired
    public void setInterviewDao(InterviewDAO interviewDao){
        this.interviewDao = interviewDao;
    }

//    @Transactional
//    @Override
//    public List<List<Interview>> getListInterview(){
//        List<Interview> interview = interviewDao.getInterview();
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
//        return listBoCui;
//    }
@Transactional
@Override
public List<List<Interview>> getListInterview(String PositionName){
    List<Interview> interview = interviewDao.getInterviewByPositionName(PositionName);
    Comparator<Interview> compareByName = Comparator.comparing(Interview::getIntervieweeFullName).thenComparing(Interview::getPositionName).thenComparing(Interview::getSequence);
    List<Interview> sortedInterview = interview.stream().sorted(compareByName).collect(Collectors.toList());
    List<List<Interview>> listBoCui = new ArrayList<List<Interview>>();
    List<Interview> listNoBoCui = new ArrayList<Interview>();
    for (int i = 0; i < sortedInterview.size(); i++) {
        if (i == 0) {
            listNoBoCui.add(sortedInterview.get(i));
        } else if (i != 0) {
            if (!sortedInterview.get(i).getIntervieweeFullName().equals(sortedInterview.get(i - 1).getIntervieweeFullName()) && !sortedInterview.get(i).getPositionName().equals(sortedInterview.get(i - 1).getPositionName())) {
                listBoCui.add(listNoBoCui);
                listNoBoCui = new ArrayList<Interview>();
                listNoBoCui.add(sortedInterview.get(i));
            } else {
                listNoBoCui.add(sortedInterview.get(i));
            }
        }
    }
    listBoCui.add(listNoBoCui);
    return listBoCui;
}
    @Transactional
    @Override
    public List<Interview> getListInterviewByPositionName(String PositionName){
        return this.interviewDao.getInterviewByPositionName(PositionName);
    }

    @Transactional
    @Override
    public void createNewInterview(Interview interview){
        Position position = positionDAO.getPositionByName(interview.getPositionName());
        InterviewType interviewType = interviewTypeDAO.getInterviewType(position, interview.getSequence());
        PotentialCandidate potentialCandidate = potentialCandidateDAO.getPotentialCandidateByName(interview.getIntervieweeFirstName(), interview.getIntervieweeLastName());
        Employee employee = employeeDAO.getEmployeeByName(interview.getInterviewerFirstName(), interview.getInterviewerLastName());
        interviewDao.createInterview(interview, potentialCandidate, employee, interviewType);
    }

    @Override
    @Transactional
    public List<String> getStringListPositionName(){
        return positionDAO.listPosition();
    }

    @Override
    @Transactional
    public List<String> getEmployeeName(){
        return interviewDao.getEmployeeName();
    }
    @Override
    @Transactional
    public List<String> getCandidateName(){
        return potentialCandidateDAO.getCandidateName();
    }

}
