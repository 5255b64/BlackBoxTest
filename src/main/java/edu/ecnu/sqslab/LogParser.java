package edu.ecnu.sqslab;

public class LogParser {
    private final String PROBE_COUNTER_PREFIX = "PROBE_ID";
    private final String PROBE_PREFIX = "ACCURATE_PROBE";
    private final String TESTCASE_NUM_PREFIX = "TEST_CASE_NUM";
    private final String TESTCASE_PREFIX = "TEST_CASE";

    private int probeNum;
    private int currentTestcaseNum;
    private TestSuiteManager testSuite;

    public LogParser() {
        probeNum = 0;
        currentTestcaseNum = -1;
        testSuite = null;
    }

    public LogParser(TestSuiteManager testSuite) {
        this();
        this.testSuite = testSuite;
    }

    public void parse(String input) {
        // TODO
        String[] strs = input.split(System.lineSeparator());
        for (String str : strs) {
            parseLine(str);
        }
    }

    public void parseLine(String input) {
        if (input.startsWith(TESTCASE_NUM_PREFIX)) {
            int testcaseNum = Integer.parseInt(input.split(" ")[1]);
            testSuite.addTestcase(testcaseNum);
            setCurrentTestcaseNum(testcaseNum);
        } else if (input.startsWith(PROBE_COUNTER_PREFIX)) {
            setProbeNum(probeNum + 1);
        } else if (currentTestcaseNum >= 0) {
            if (input.startsWith(TESTCASE_PREFIX)) {
                String testcaseCode = input.split(" ")[1];
                testSuite.setTestcaseCode(testcaseCode);
            } else if (input.startsWith(PROBE_PREFIX)) {
                String probeInfo = input.replaceFirst(PROBE_PREFIX + " ", "");
                testSuite.addProbeInfo(probeInfo);
            }
        } else {
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

    public TestSuiteManager getTestSuite() {
        return testSuite;
    }

    public void setTestSuite(TestSuiteManager testSuite) {
        this.testSuite = testSuite;
    }

    public void printTestSuite() {
        testSuite.print();
    }
}
