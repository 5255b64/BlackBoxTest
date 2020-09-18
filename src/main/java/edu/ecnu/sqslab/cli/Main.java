package edu.ecnu.sqslab.cli;

import com.alibaba.fastjson.JSONWriter;
import edu.ecnu.sqslab.LogParser;
import edu.ecnu.sqslab.feature.CstpFeatureParser;
import edu.ecnu.sqslab.feature.IFeatureParser;
import edu.ecnu.sqslab.rules.FxDealLogRules;
import edu.ecnu.sqslab.rules.FxOptionDealLogRules;
import edu.ecnu.sqslab.rules.FxclDealLogRules;
import edu.ecnu.sqslab.rules.IRule;
import edu.ecnu.sqslab.testsuite.TestSuiteManager;
import edu.ecnu.sqslab.testsuite.Testcase;
import org.apache.commons.cli.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /**
     * 可用的规则类
     * 在OptionalRules数组以外的规则类 不作处理
     */
//    private static final String[] optionalRules = {"FxclDealLog", "FxDealLog", "FxOptionDealLog"};
    private static final Map<String, Class> optionalRules;

    static {
        optionalRules = new HashMap<>();
        optionalRules.put("FxclDealLog", FxclDealLogRules.class);
        optionalRules.put("FxDealLog", FxDealLogRules.class);
        optionalRules.put("FxOptionDealLog", FxOptionDealLogRules.class);
    }

    private static Options OPTIONS = new Options();
    private static CommandLine commandLine;
    private static String HELP_STRING = null;

    /**
     * @param args
     */
    public static void main(String[] args) {
        initCliArgs(args);
    }

    /**
     * 参数初始化
     * 必要参数如下：
     * -n 表示n-way的n（default=2）
     * -r Rule 表示使用的规则
     * -i InputFilePath 输入文件路径
     * -o OutputFilePath 输出文件路径
     *
     * @param args args
     */
    private static void initCliArgs(String[] args) {
        CommandLineParser commandLineParser = new DefaultParser();
        // help
        OPTIONS.addOption("help", "usage help");
        // 参数n
        OPTIONS.addOption(Option.builder("n").argName("n_way").hasArg(true).type(Integer.class).desc("n-way parameter").build());
        // 参数InputFilePath
        OPTIONS.addOption(Option.builder("i").hasArg(true).longOpt("input").type(String.class).desc("Input File Path 输入文件路径").build());
        // 参数OutputFilePath
        OPTIONS.addOption(Option.builder("o").hasArg(true).longOpt("output").type(String.class).desc("Output File Path 输出文件路径").build());
        // 参数Rule
        OPTIONS.addOption(Option.builder("r").hasArg(true).longOpt("rule").type(String.class).desc("Rule 规则").build());
        try {
            commandLine = commandLineParser.parse(OPTIONS, args);
            boolean flag = true;
            if (!commandLine.hasOption("n")) {
                flag = false;
                System.err.println("缺少参数-n");
            }
            if (!commandLine.hasOption("i")) {
                flag = false;
                System.err.println("缺少参数-i");
            }
            if (!commandLine.hasOption("o")) {
                flag = false;
                System.err.println("缺少参数-o");
            }
            if (!commandLine.hasOption("r")) {
                flag = false;
                System.err.println("缺少参数-r");
            }
            if (flag) {
                int n = Integer.parseInt(commandLine.getOptionValue("n"));
                String inputFilePath = commandLine.getOptionValue("i");
                String outputFilePath = commandLine.getOptionValue("o");
                String rule = commandLine.getOptionValue("r");
                if (optionalRules.containsKey(rule)) {
                    Class clazz = optionalRules.get(rule);
                    try {
                        // 处理日志
                        System.out.println("处理日志");
                        IFeatureParser parser = new CstpFeatureParser((IRule) clazz.getConstructor().newInstance());
                        LogParser lp = new LogParser(new TestSuiteManager());
                        BufferedReader in = new BufferedReader(new FileReader(inputFilePath));
                        String str;
                        while ((str = in.readLine()) != null) {
                            lp.parse(str);
                        }
                        lp.getAllTestcaseFeature(parser, n);
                        // 获取TestSuite对象
                        System.out.println("获取TestSuite对象");
                        List<Testcase> testSuite = lp.getTestSuite();
//                        lp.printTestSuite();
                        // 保存json文件
                        System.out.println("保存json特征文件");
                        JSONWriter writer = new JSONWriter(new FileWriter(outputFilePath));
                        writer.startArray();
                        writer.writeValue(new Object() {
                            public int totalProbeNum = lp.getProbeNum();
                        });
                        int counter = 0;
                        str = String.valueOf(testSuite.size());
                        for (Testcase tc : testSuite) {
                            counter++;
                            System.out.println("保存json特征文件:"+String.valueOf(counter) + "/" + str);
                            writer.writeValue(tc);
                        }
                        writer.endArray();
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("不存在规则：" + rule);
                }
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage() + "\n" + getHelpString());
            System.exit(0);
        }

    }

    /**
     * get string of help usage
     *
     * @return help string
     */
    private static String getHelpString() {
        if (HELP_STRING == null) {
            HelpFormatter helpFormatter = new HelpFormatter();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            helpFormatter.printHelp(printWriter, HelpFormatter.DEFAULT_WIDTH, "scp -help", null,
                    OPTIONS, HelpFormatter.DEFAULT_LEFT_PAD, HelpFormatter.DEFAULT_DESC_PAD, null);
            printWriter.flush();
            HELP_STRING = new String(byteArrayOutputStream.toByteArray());
            printWriter.close();
        }
        return HELP_STRING;
    }
}
