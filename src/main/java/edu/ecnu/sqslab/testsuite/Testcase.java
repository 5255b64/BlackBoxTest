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
    private int accureteProbeNum;

    /**
     * 测试用例的数量
     */
    private int testcaseNum;

    /**
     * 保存测试用例的特征值
     */
    private List<Integer> feature;

    public Testcase(){
        testcaseCode=null;
        probeInfos=new HashMap();
        probeNum=0;
        accureteProbeNum=0;
        testcaseNum=-1;
        feature=new ArrayList<>();
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
        probeNum++;
        if(probeInfos.containsKey(probeInfo)){
            probeInfos.put(probeInfo, probeInfos.get(probeInfo)+1);
        }else {
            probeInfos.put(probeInfo, 1);
            accureteProbeNum++;
        }
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

    public int getAccureteProbeNum(){
        return accureteProbeNum;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TestcaseNum: ").append(String.valueOf(testcaseNum)).append(System.lineSeparator());
        stringBuffer.append("TestcaseCode: ").append(testcaseCode).append(System.lineSeparator());
        stringBuffer.append("TestcaseProbeNum: ").append(probeNum).append(System.lineSeparator());
        stringBuffer.append("TestcaseUniqueProbeNum: ").append(probeInfos.size()).append(System.lineSeparator());
        stringBuffer.append("TestcaseFeature: ").append(feature.toString()).append(System.lineSeparator());
        stringBuffer.append(System.lineSeparator());
        return stringBuffer.toString();
    }

    public void print() {
        System.out.println("TestcaseNum: "+String.valueOf(testcaseNum));
        System.out.println("TestcaseCode: "+testcaseCode);
        System.out.println("TestcaseProbeNum: "+probeInfos.size());
        System.out.println("TestcaseFeature: "+feature.toString());
        System.out.println();
    }
}
