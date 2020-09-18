package edu.ecnu.sqslab.feature;

import edu.ecnu.sqslab.rules.discrete.DiscreteRule;

import java.util.List;
import java.util.Map;

/**
 * 特征抽取器
 * 用于抽取n-way特征
 */
public interface IFeatureParser {

    /**
     * 获取 n-way特征
     * 需要提前调用boolean setN(int n);方法 设定维度值
     * @param testcaseStr 输入测试用例
     * @return
     */
    public List<Integer> getFeature(String testcaseStr, int n);

    /**
     * 处理测试用例
     * 将测试用例的“字段-取值”映射为
     * Map<String, String>类型的Map
     *
     * @param testcaseStr 测试用例输入
     * @return Map<String, String>类型的Map
     * 表示测试用例的“字段-取值”关系
     */
    public Map<String, String> testcaseParserStrMap(String testcaseStr);

    /**
     * 处理测试用例
     * Map<String, String>类型的的“字段-取值”映射Map
     * 根据离散规则 DiscreteRule dRule
     * 转换为Map<Integer, Integer>类型的“字段-取值”Map
     *
     * @param testcaseStrMap Map<String, String>类型的Map
     * @return 一条testcase的Map<Integer, Integer>映射
     */
    public Map<Integer, Integer> testcaseParserIntMap(Map<String, String> testcaseStrMap);

}
