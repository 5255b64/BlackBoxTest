package edu.ecnu.sqslab;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteManager {
    List<Testcase> testSuite;   // 保存测试用例的数组
    Testcase currentTestcase;   // 指向数组尾端对象的引用

    public TestSuiteManager(){
        testSuite=new ArrayList<>();
        currentTestcase=null;
    }

    public void addTestcase(String testcaseCode){
        currentTestcase=new Testcase(testcaseCode);
        testSuite.add(currentTestcase);
    }

    public void addTestcase(int testcaseNum){
        currentTestcase=new Testcase(testcaseNum);
        testSuite.add(currentTestcase);
    }

    public void addTestcase(String testcaseCode, int testcaseNum){
        currentTestcase=new Testcase(testcaseCode, testcaseNum);
        testSuite.add(currentTestcase);
    }

    public void addProbeInfo(String probeInfo){
        currentTestcase.addProbeInfo(probeInfo);
    }

    public void setTestcaseCode(String testcaseCode){
        currentTestcase.setTestcaseCode(testcaseCode);
    }

    public void print() {
        for(Testcase tc:testSuite){
            tc.print();
        }
    }
}
