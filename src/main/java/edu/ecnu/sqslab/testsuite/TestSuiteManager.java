package edu.ecnu.sqslab.testsuite;

import edu.ecnu.sqslab.feature.IFeatureParser;

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

    /**
     * 对象：TestSuite中的所有的测试用例
     * 功能：计算每条测试用例的n-way特征
     * @param n n-way特征参数
     * @param parser 特征抽取器
     */
    public void getAllTestcaseFeature(IFeatureParser parser, int n){
        int counter = 0;
        String str = String.valueOf(testSuite.size());
        for(Testcase tc:testSuite){
            counter++;
            System.out.println("计算组合特征:"+String.valueOf(counter)+"/"+str);
            tc.setFeature(parser.getFeature(tc.getTestcaseCode(),n));
        }
    }

    public List<Testcase> getTestSuite(){
        return testSuite;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for(Testcase tc:testSuite){
            stringBuffer.append(tc.toString());
        }
        return stringBuffer.toString();
    }

    public void print() {
        for(Testcase tc:testSuite){
            tc.print();
        }
    }
}
