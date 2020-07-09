package edu.ecnu.sqslab.feature;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.sqslab.rules.discrete.DiscreteRule;
import edu.ecnu.sqslab.util.MyPair;

import java.util.*;

import static edu.ecnu.sqslab.Config.DEFAULT_FEATURE_VALUE_INVALID;

public class CstpFeatureParser {
    public static Map<String, String> getFieldMap(String testcaseStr) {
        Map<String, String> result = new HashMap<>();
        JSONObject object = JSONObject.parseObject(testcaseStr);
        for (Map.Entry entry : object.entrySet()) {
            for (Map.Entry fieldObejct : ((JSONObject) entry.getValue()).entrySet()) {
                // 首字母大写
                String fieldName = (String) fieldObejct.getKey();
                String fieldValue = (String) fieldObejct.getValue();
                char[] ch = fieldName.toCharArray();
                if (fieldName.length() > 0 && ch[0] >= 'a' && ch[0] <= 'z') {
                    ch[0] = (char) (ch[0] - 32);
                }
                String newFieldName = String.valueOf(ch);
                result.put(newFieldName, fieldValue);
            }
        }
        return result;
    }

    /**
     * 获取0-Way特征
     * @param testcaseStr 测试用例代码
     * @param dRule 离散规则对象
     * @return 返回特征值列表 根据字段名进行排序
     */
    public static List<MyPair<String, Integer>> get1WayFeature(String testcaseStr, DiscreteRule dRule) throws Exception {
        if (testcaseStr == null) {
            throw new Exception("getNWayFeature 参数testcaseStr为null");
        }
        if (dRule == null) {
            throw new Exception("getNWayFeature 参数dRule为null");
        }
        List<MyPair<String, Integer>> result = new ArrayList<>();
        Map<String, String> valueMap = getFieldMap(testcaseStr);
        Set<String> fieldList = dRule.getRuleMap().keySet();
        for (String fieldName : fieldList) {
            int tmpNum = DEFAULT_FEATURE_VALUE_INVALID; //缺省值
            if(fieldList.contains(fieldName)){
                try {
                    tmpNum = dRule.getAttributeNum(fieldName, valueMap.get(fieldName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            result.add(new MyPair<>(fieldName, tmpNum));
        }
        return result;
    }

    /**
     * 获取n-Way特征
     * @param testcaseStr 测试用例代码
     * @param dRule 离散规则对象
     * @return 返回特征值列表 根据字段名进行排序
     */
    public static List<MyPair<String, Integer>> getNWayFeature(String testcaseStr, DiscreteRule dRule, int n) throws Exception {
        if(n==1){
            return get1WayFeature(testcaseStr, dRule);
        }
        if(n<1){
            throw new Exception("getNWayFeature 参数n取值错误：\t"+String.valueOf(n));
        }
        if (testcaseStr == null) {
            throw new Exception("getNWayFeature 参数testcaseStr为null");
        }
        if (dRule == null) {
            throw new Exception("getNWayFeature 参数dRule为null");
        }

        List<MyPair<String, Integer>> result = new ArrayList<>();
        // TODO

        return result;
    }
}
