package com.bfs.backend.responseDomain;

import java.io.Serializable;
import java.util.List;

public class candidateIdList implements Serializable {
    private List<Integer> candidate;

    public candidateIdList(List<Integer> candidate){
        this.candidate = candidate;
    }

    public candidateIdList(){
    }

    public List<Integer> getCandidate(){
        return candidate;
    }

    public void setCandidate(List<Integer> candidate){
        this.candidate = candidate;
    }

}
