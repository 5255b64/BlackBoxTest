package edu.ecnu.sqslab.testsuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testcase {
    /**
     * 测试用例具体字段以及参数
     */
    private String testcaseCode;
    /**
     * 保存执行过的桩信息
     */
    private Map<String, Integer> probeInfos;

    /**
     * 保存触发过的桩数量(累计重复)
     */
    private int probeNum;

    /**
     * 保存触发过的桩数量(不累计重复)
     */
    private int absoluteProbeNum;

    /**
     * 测试用例的编号
     */
    private int testcaseID;

    /**
     * 保存测试用例的特征值
     */
    private List<Integer> feature;

    public Testcase(){
        testcaseCode=null;
        probeInfos=new HashMap();
        probeNum=0;
        absoluteProbeNum =0;
        testcaseID =-1;
        feature=new ArrayList<>();
    }

    public Testcase(String testcaseCode){
        this();
        this.testcaseCode=testcaseCode;
    }

    public Testcase(int testcaseID){
        this();
        this.testcaseID = testcaseID;
    }

    public Testcase(String testcaseCode,int testcaseID){
        this();
        this.testcaseCode=testcaseCode;
        this.testcaseID = testcaseID;
    }

    public void addProbeInfo(String probeInfo){
        probeNum++;
        if(probeInfos.containsKey(probeInfo)){
            probeInfos.put(probeInfo, probeInfos.get(probeInfo)+1);
        }else {
            probeInfos.put(probeInfo, 1);
            absoluteProbeNum++;
        }
    }

    public String getTestcaseCode() {
        return testcaseCode;
    }

    public void setTestcaseCode(String testcaseCode) {
        this.testcaseCode = testcaseCode;
    }

    public int getTestcaseID() {
        return testcaseID;
    }

    public void setTestcaseID(int testcaseID) {
        this.testcaseID = testcaseID;
    }

    public List<Integer> getFeature(){
        return feature;
    }

    public void setFeature(List<Integer> feature){
        this.feature=feature;
    }

    public Map<String, Integer> getProbeInfos(){
        return probeInfos;
    }

    public int getProbeNum(){
        return probeNum;
    }

    public int getAbsoluteProbeNum(){
        return absoluteProbeNum;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TestcaseNum: ").append(String.valueOf(testcaseID)).append(System.lineSeparator());
        stringBuffer.append("TestcaseCode: ").append(testcaseCode).append(System.lineSeparator());
        stringBuffer.append("TestcaseProbeNum: ").append(probeNum).append(System.lineSeparator());
        stringBuffer.append("TestcaseUniqueProbeNum: ").append(probeInfos.size()).append(System.lineSeparator());
        stringBuffer.append("TestcaseFeature: ").append(feature.toString()).append(System.lineSeparator());
        stringBuffer.append(System.lineSeparator());
        return stringBuffer.toString();
    }

    public void print() {
        System.out.println("TestcaseNum: "+String.valueOf(testcaseID));
        System.out.println("TestcaseCode: "+testcaseCode);
        System.out.println("TestcaseProbeNum: "+probeInfos.size());
        System.out.println("TestcaseFeature: "+feature.toString());
        System.out.println();
    }
}
