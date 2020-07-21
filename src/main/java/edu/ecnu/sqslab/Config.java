package edu.ecnu.sqslab;

public class Config {
    public static final int DEFAULT_FEATURE_VALUE_INVALID = -2; // 特征值缺省值 表示在规则中无法找到测试用例字段（找不到给定规则）
    public static final int DEFAULT_FEATURE_VALUE_NO_RULE = 1; // 特征值缺省值 表示在规则中无法找到目标值的值域（取值在给定规则之外）
    public static final int DEFAULT_FEATURE_BLANK = 0; // 特征值缺省值 表示测试用例字段取值为空
    public static final String DEFAULT_FIELD_NAME = "DEFAULT"; // 字段名缺省值
    public static final String RULE_BLANK = "#BLANK#";  //
    public static final String RULE_OUT_OF_RULE = "#OUT_OF_RULE#";  //

}
