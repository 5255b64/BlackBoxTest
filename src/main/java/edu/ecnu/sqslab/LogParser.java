package edu.ecnu.sqslab;

import edu.ecnu.sqslab.feature.IFeatureParser;
import edu.ecnu.sqslab.testsuite.TestSuiteManager;
import edu.ecnu.sqslab.testsuite.Testcase;

import java.util.List;

public class LogParser {
    /**
     * javaagent插桩时 日志中记录PROBE_ID前缀+ID号
     */
    private final String PROBE_COUNTER_PREFIX = "PROBE_ID ";
    /**
     * 被插桩代码执行时 日志中记录ACCURATE_PROBE前缀+代码行标识信息
     */
    private final String PROBE_PREFIX = "ACCURATE_PROBE ";
    /**
     * 输入新的测试用例时 日志中记录TEST_CASE_NUM前缀+测试用例号
     */
    private final String TESTCASE_NUM_PREFIX = "TEST_CASE_NUM ";
    /**
     * 输入测试用例的具体参数值时 日志中记录其具体信息
     */
    private final String TESTCASE_PREFIX = "TEST_CASE ";

    private int probeNum;
    private int currentTestcaseNum;
    private TestSuiteManager tsm;

    public LogParser() {
        probeNum = 0;
        currentTestcaseNum = -1;
        tsm = null;
    }

    public LogParser(TestSuiteManager testSuite) {
        this();
        this.tsm = testSuite;
    }

    public void parse(String input) {
        String[] strs = input.split(System.lineSeparator());
        for (String str : strs) {
            parseLine(str);
        }
    }

    public void parseLine(String input) {
        if (input.startsWith(TESTCASE_NUM_PREFIX)) {
            int testcaseNum = Integer.parseInt(input.split(" ")[1]);
            tsm.addTestcase(testcaseNum);
            setCurrentTestcaseNum(testcaseNum);
        } else if (input.startsWith(PROBE_COUNTER_PREFIX)) {
            setProbeNum(probeNum + 1);
        } else if (currentTestcaseNum >= 0) {
            if (input.startsWith(TESTCASE_PREFIX)) {
                /**
                 * 注 input.split(" ")之后
                 * 若测试用例中本身存在空格 会被分隔成多段
                 * 应将多段测试用例拼接起来
                 */
                String[] splits = input.split(" ");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(splits[1]);
                for(int i=2;i<splits.length;i++){
                    stringBuffer.append(" ").append(splits[i]);
                }
                tsm.setTestcaseCode(stringBuffer.toString());
            } else if (input.startsWith(PROBE_PREFIX)) {
//                String probeInfo = input.replaceFirst(PROBE_PREFIX, "");

                tsm.addProbeInfo(input.split(" ", 2)[1]);
//                tsm.addProbeInfo(input);
            }
        } else {
            /**
             * 在执行测试用例之前（初始化阶段）
             * 可能会事先执行插装过的代码
             */
            System.err.println("currentTestcaseNum < 0 : " + input);
        }
    }

    public int getCurrentTestcaseNum() {
        return currentTestcaseNum;
    }

    public void setCurrentTestcaseNum(int currentTestcaseNum) {
        this.currentTestcaseNum = currentTestcaseNum;
    }

    public int getProbeNum() {
        return probeNum;
    }

    public void setProbeNum(int probeNum) {
        this.probeNum = probeNum;
    }

    public TestSuiteManager getTsm() {
        return tsm;
    }

    public void setTsm(TestSuiteManager tsm) {
        this.tsm = tsm;
    }

    /**
     * 对象：TestSuite中的所有的测试用例
     * 功能：计算每条测试用例的n-way特征
     * @param n n-way特征参数
     * @param parser 特征抽取器
     */
    public void getAllTestcaseFeature(IFeatureParser parser, int n){
        tsm.getAllTestcaseFeature(parser, n);
    }

    public List<Testcase> getTestSuite(){
        return tsm.getTestSuite();
    }
    public void printTestSuite() {
        tsm.print();
    }
}
