package edu.ecnu.sqslab.feature;

import edu.ecnu.sqslab.rules.IRule;
import edu.ecnu.sqslab.rules.discrete.DiscreteRule;
import edu.ecnu.sqslab.rules.discrete.FieldRule;
import edu.ecnu.sqslab.util.CombinationPair;

import java.util.*;

import static edu.ecnu.sqslab.Config.DEFAULT_FEATURE_VALUE_INVALID;

/**
 * 特征提取器的抽象类 实现了通用的主要方法
 * 子类只需要实现
 * testcaseParserStrMap
 * 即可
 */
abstract public class AFeatureParser implements IFeatureParser {
    IRule oldRuld;                      // 使用的原始规则
    DiscreteRule dRule;                 // 使用的离散规则
    int nDimension = -1;                // n-way的维度值n
        Map<String, Integer> vectorMap;     // 特征向量表

    public abstract Map<String, String> testcaseParserStrMap(String testcaseStr);

    /**
     * 设置特征向量表
     *
     * @param nDimension
     */
    protected void setVectorTable(int nDimension) {
        vectorMap = new HashMap<>();
        // 根据rule 计算出所有可能的combination
        //  初始化 1-way combination
        List<FieldRule> ruleList = dRule.getRuleList();
        List<List<CombinationPair<Integer, Integer>>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        //  递归获取 n-way combination
        List<List<CombinationPair<Integer, Integer>>> result =
                setVectorTableRecursion(input, ruleList, nDimension);

        // 初始化特征向量表 Map<String, Integer> vectorMap
        for (int i = 0; i < result.size(); i++) {
            StringBuilder attritubeStr = new StringBuilder();
            List<CombinationPair<Integer, Integer>> comb = result.get(i);
            for (int j = 0; j < comb.size(); j++) {
                CombinationPair<Integer, Integer> combPair = comb.get(j);
                attritubeStr.append(combPair.getKey()).append(":").append(combPair.getValue()).append(";");
            }
            vectorMap.put(attritubeStr.toString(), 0);
        }
    }

    private List<List<CombinationPair<Integer, Integer>>> setVectorTableRecursion(
            List<List<CombinationPair<Integer, Integer>>> input,
            List<FieldRule> ruleList,
            int n) {
        if (n <= 0) {
            return input;
        }

        List<List<CombinationPair<Integer, Integer>>> output = new ArrayList<>();
        for (List<CombinationPair<Integer, Integer>> tempComb : input) {
            for (int ruleNum = 0; ruleNum < ruleList.size(); ruleNum++) {
                boolean flag = true;
                for (int combNum = 0; combNum < tempComb.size(); combNum++) {
                    if (tempComb.get(combNum).compareTo(ruleNum) >= 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int fieldNum = 0; fieldNum < ruleList.get(ruleNum).getRuleNum(); fieldNum++) {
                        List<CombinationPair<Integer, Integer>> newComb = new ArrayList<>(tempComb);
                        newComb.add(new CombinationPair<Integer, Integer>(ruleNum, fieldNum));
                        output.add(newComb);
                    }
                }
            }
        }
        return setVectorTableRecursion(output, ruleList, n - 1);
    }

    public boolean setNDimension(int n) {
        if (n < 1) {
            return false;
        } else {
            if (nDimension != n) {
                nDimension = n;
                setVectorTable(nDimension);
            }
        }
        return true;
    }

    public List<Integer> getFeature(String testcaseStr, int n) {
        setNDimension(n);
        // 检查维度值n是否初始化
        if (nDimension < 1) {
            return null;
        }
        Map<Integer, Integer> testcaseMap = testcaseParserIntMap(testcaseParserStrMap(testcaseStr));
        List<String> testcaseCombination = getTestcaseCombination(testcaseMap);
        return fillFeatureVertor(testcaseCombination);
    }

    /**
     * 获取testcase中包含的所有n-way组合
     * 调用getTestcaseCombinationRecursive进行递归计算
     *
     * @param testcaseMap
     * @return
     */
    protected List<String> getTestcaseCombination(Map<Integer, Integer> testcaseMap) {
        // 初始化列表list 用于递归操作
        List<List<CombinationPair<Integer, Integer>>> list = new ArrayList<>();

        for (Map.Entry entry : testcaseMap.entrySet()) {
            List<CombinationPair<Integer, Integer>> tmpList = new ArrayList<>();
            tmpList.add(new CombinationPair<Integer, Integer>((Integer) entry.getKey(), (Integer) entry.getValue()));
            list.add(tmpList);
        }

        List<List<CombinationPair<Integer, Integer>>> recursiveResult =
                getTestcaseCombinationRecursive(list, testcaseMap, nDimension);

        // 将数据转换为字符串 插入列表result中
        List<String> result = new ArrayList<>();
        for (List<CombinationPair<Integer, Integer>> tempComb : recursiveResult) {
            StringBuilder str = new StringBuilder();
            for (CombinationPair<Integer, Integer> pair : tempComb) {
                str.append(pair.getKey()).append(":").append(pair.getValue()).append(";");
            }
            result.add(str.toString());
        }
        return result;
    }

    /**
     * getTestcaseCombination方法的递归方法
     *
     * @param list
     * @param testcaseMap
     * @param n
     * @return
     */
    private List<List<CombinationPair<Integer, Integer>>> getTestcaseCombinationRecursive(
            List<List<CombinationPair<Integer, Integer>>> list,
            Map<Integer, Integer> testcaseMap,
            int n) {
        if (n <= 1) {
            return list;
        }
        List<List<CombinationPair<Integer, Integer>>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            List<CombinationPair<Integer, Integer>> tempComb = list.get(i);
            for (Map.Entry entry : testcaseMap.entrySet()) {
                boolean flag = true;
                CombinationPair<Integer, Integer> newPair = new CombinationPair<Integer, Integer>((Integer) entry.getKey(), entry.getValue());
                for (int j = 0; j < tempComb.size(); j++) {
                    if (tempComb.get(j).compareTo(newPair) >= 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    List<CombinationPair<Integer, Integer>> newComb = new ArrayList<>(tempComb);
                    newComb.add(newPair);
                    result.add(newComb);
                }
            }
        }
        return getTestcaseCombinationRecursive(result, testcaseMap, n - 1);
    }

    /**
     * 根据测试用例中包含的所有Combination
     * 获取定长的特征向量
     * <p>
     * 首先获取一个空的特征向量
     *
     * @param testcaseCombination
     * @return
     */
    private List<Integer> fillFeatureVertor(List<String> testcaseCombination) {
        List<Integer> result = new LinkedList<>();
        // 获取空的特征向量
        Map<String, Integer> newVectorMap = new HashMap<>(vectorMap);   // 调用拷贝构造函数

        // 将测试用例中的所有combination填入空的特征向量中
        for (String str : testcaseCombination) {
            try {
                newVectorMap.put(str, newVectorMap.get(str) + 1);
            } catch (Exception e) {
                System.err.println("找不到规则：" + String.valueOf(str));
                e.printStackTrace();
            }
        }

        // 特征向量从map转换为list
        for (Map.Entry entry : newVectorMap.entrySet()) {
            result.add((Integer) entry.getValue());
        }

        return result;
    }

    /**
     * 处理测试用例
     * Map<String, String>类型的的“字段-取值”映射Map
     * 根据离散规则 DiscreteRule dRule
     * 转换为Map<Integer, Integer>类型的“字段-取值”Map
     *
     * @param testcaseStrMap Map<String, String>类型的Map
     * @return 一条testcase的Map<Integer, Integer>映射
     */
    @Override
    public Map<Integer, Integer> testcaseParserIntMap(Map<String, String> testcaseStrMap) {
        Map<Integer, Integer> result = new HashMap<>();

        Set<String> ruleFieldList = dRule.getRuleMap().keySet();            // 离散规则 字段 Set
        for (String fieldName : ruleFieldList) {
            int attrubuteValue = DEFAULT_FEATURE_VALUE_INVALID; //缺省值
            try {
                attrubuteValue = dRule.getAttributeNum(fieldName, testcaseStrMap.get(fieldName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            int attritubeNum = dRule.getRuleMap().get(fieldName).getFieldNum();
            result.put(attritubeNum, attrubuteValue);
        }
        return result;
    }
}
