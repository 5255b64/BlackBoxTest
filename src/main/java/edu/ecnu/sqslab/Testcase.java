package edu.ecnu.sqslab;

import java.util.ArrayList;
import java.util.List;

public class Testcase {
    private String testcaseCode;
    private List<ProbeInfo> probeInfos;
    private int testcaseNum;

    public Testcase(){
        testcaseCode=null;
        probeInfos=new ArrayList<>();
        testcaseNum=-1;
    }

    public Testcase(String testcaseCode){
        this();
        this.testcaseCode=testcaseCode;
    }

    public Testcase(int testcaseNum){
        this();
        this.testcaseNum=testcaseNum;
    }

    public Testcase(String testcaseCode,int testcaseNum){
        this();
        this.testcaseCode=testcaseCode;
        this.testcaseNum=testcaseNum;
    }

    public void addProbeInfo(String probeInfo){
        probeInfos.add(new ProbeInfo(probeInfo));
    }

    public String getTestcaseCode() {
        return testcaseCode;
    }

    public void setTestcaseCode(String testcaseCode) {
        this.testcaseCode = testcaseCode;
    }

    public int getTestcaseNum() {
        return testcaseNum;
    }

    public void setTestcaseNum(int testcaseNum) {
        this.testcaseNum = testcaseNum;
    }

    public void print() {
        System.out.println("TestcaseNum: "+String.valueOf(testcaseNum));
        System.out.println("TestcaseCode: "+testcaseCode);
        for(ProbeInfo pi:probeInfos){
            pi.print();
        }
    }

    //TODO
}
