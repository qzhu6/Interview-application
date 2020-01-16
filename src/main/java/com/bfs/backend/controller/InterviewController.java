package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.Interview;
import com.bfs.backend.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InterviewController {

    private InterviewService interviewService;

    @Autowired
    public void setInterviewService(InterviewService interviewService){
        this.interviewService = interviewService;
    }

    @GetMapping("/interview")
    public List<List<Interview>> getInterview(){
        List<Interview> interview = interviewService.getListInterview();
//        List<Interview> interview = interviewDao.getInterview();
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
}
