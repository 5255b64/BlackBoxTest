package edu.ecnu.sqslab.rules;

import java.util.Map;

public interface IRule {
    public Map<String,String> getRuleMap();

    /*
     * 例子：接口规则
     * 每个字段以一个成员变量的形式表示
     * 变量前缀均为 public static String
     * 变量名为字段名
     * 变量值为字符串 其规则如下
     * 空字符串“”：表示取值为 空/随机字符串
     * 单个字符串“abc”：表示取值为 空/随机字符串/给定字符串“abc”
     * 以逗号分隔的字符串"1,2,3":表示取值为 空/1/2/3
     * 以逗号分隔的字符串"1,2,3-5"，每个分隔中存在"a-b"的形式，表示范围: 取值为 空/1/2/3-5之间的数
     */
//    public static String ClearingMethod = "1,2,3";
}
