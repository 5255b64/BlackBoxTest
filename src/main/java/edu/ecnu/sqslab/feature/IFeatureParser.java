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
    List<Integer> getFeature(String testcaseStr, int n);

}
