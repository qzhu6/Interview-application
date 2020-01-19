package com.bfs.backend.responseDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class myCandidateList {
    public myCandidateList(){
    }
    private List<myCandidate> candidateList;


}
