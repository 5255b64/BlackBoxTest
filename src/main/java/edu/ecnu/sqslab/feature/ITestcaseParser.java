package edu.ecnu.sqslab.feature;

import java.util.Map;

/**
 * 将String形式的 testcase 分解为多个字段与字段值
 */
public interface ITestcaseParser {
    Map<String,String> getFieldMap(String testcase);   // 获取 字段-值 的映射关系
}
