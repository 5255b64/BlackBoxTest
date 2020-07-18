package edu.ecnu.sqslab.testsuite;

public class ProbeInfo {
    private String className;
    private String funcName;
    private String fileName;
    private int lineNum;
    private String threadNum;
    private String funcSignature;

    /**
     * 输入一行的插装信息 生成单个桩的对象
     *
     * @param probeLog
     */
    public ProbeInfo(String probeLog) {
        String[] strs = probeLog.split(" ");
        try {
            className = strs[1];
            funcName = strs[2];
            fileName = strs[3];
            lineNum = Integer.parseInt(strs[4]);
            threadNum = strs[5];
            funcSignature = strs[6];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(String threadNum) {
        this.threadNum = threadNum;
    }

    public String getFuncSignature() {
        return funcSignature;
    }

    public void setFuncSignature(String funcSignature) {
        this.funcSignature = funcSignature;
    }

    public void print() {
        System.out.println(className + " " + funcName + " " + fileName + " " + String.valueOf(lineNum) + " " + threadNum + " " + funcSignature);
    }
}
