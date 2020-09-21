package edu.ecnu.sqslab.feature;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.ecnu.sqslab.rules.IRule;
import edu.ecnu.sqslab.rules.discrete.DiscreteRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bcbip构件的特征提取器
 * 需要考虑规则中的类嵌套
 * 以及规则中的List嵌套
 */
public class BcbipFeatureParser extends AFeatureParser implements IFeatureParser {
    // 参考CstpFeatureParser的代码
    public BcbipFeatureParser(IRule oldRuld) {
        this.oldRuld = oldRuld;
        this.dRule = new DiscreteRule(oldRuld);
        vectorMap = null;
    }

    public BcbipFeatureParser(DiscreteRule dRule) {
        this.oldRuld = null;
        this.dRule = dRule;
        vectorMap = null;
    }

    @Override
    public Map<String, String> testcaseParserStrMap(String testcaseStr) {
        JSONObject object = JSONObject.parseObject(testcaseStr);
        return BcbipFeatureParser.testcaseParserStrMapRecursion(object);
    }

    /**
     * testcaseParserStrMap方法的递归方法
     *
     * @param object JSONObject对象
     * @return
     */
    protected static Map<String, String> testcaseParserStrMapRecursion(JSONObject object) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry entry : object.entrySet()) {
            String fieldName = entry.getKey().toString();
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            if (entry.getValue() instanceof JSONObject) {
                Map<String, String> subMap = BcbipFeatureParser.testcaseParserStrMapRecursion((JSONObject) entry.getValue());
                for (Map.Entry<String, String> sub : subMap.entrySet()) {
                    String newKey = fieldName + "_" + sub.getKey();
                    result.put(newKey, sub.getValue());
                }
//                System.out.println("JSONObject " + entry.getValue() + " " + entry.getClass());
            } else if (entry.getValue() instanceof JSONArray) {
                List list = (JSONArray)entry.getValue();
                for(Object listObj:list){
                    Map<String, String> subMap = BcbipFeatureParser.testcaseParserStrMapRecursion((JSONObject)listObj);
                    for (Map.Entry<String, String> sub : subMap.entrySet()) {
                        String newKey = fieldName + "_" + sub.getKey();
                        result.put(newKey, sub.getValue());
                    }
                }
//                System.out.println("JSONArray " + entry.getValue() + " " + entry.getClass());
            } else {
//                String fieldName = (String) entry.getKey();
                String fieldValue = (String) entry.getValue();
                // 首字母大写
                String newFieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                result.put(newFieldName, fieldValue);
            }
        }
        return result;
    }
}
