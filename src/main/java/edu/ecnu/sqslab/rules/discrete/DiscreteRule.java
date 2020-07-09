package edu.ecnu.sqslab.rules.discrete;

import edu.ecnu.sqslab.rules.IRule;

import java.util.HashMap;
import java.util.Map;

/**
 * 离散规则
 * 该规则下包含多个FieldRule
 */
public class DiscreteRule {
    private Map<String, FieldRule> ruleMap = null;

    public DiscreteRule(IRule oldRule) {
        ruleMap = new HashMap<>();
        Map<String, String> oldRuleMap = oldRule.getRuleMap();
        for (Map.Entry<String, String> entry : oldRuleMap.entrySet()) {
            String fieldName = entry.getKey();
            String fieldRule = entry.getValue();
            FieldRule fr = new FieldRule(fieldRule);
            ruleMap.put(fieldName, fr);
        }
    }

    public void print() {
        for (Map.Entry<String, FieldRule> entry : ruleMap.entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue().toString());
        }
    }

    public Map<String, FieldRule> getRuleMap() {
        return this.ruleMap;
    }

    public int getAttributeNum(String fieldName, String strFieldValue) throws Exception {
        if(fieldName==null){
            throw new Exception("fieldName为空");
        }
        if(strFieldValue==null){
            throw new Exception("strFieldValue为空");
        }
        int result = -1;
        // 判断字段名是否存在
        if (ruleMap.containsKey(fieldName)) {
            result = ruleMap.get(fieldName).getAttributeNum(strFieldValue);
        } else {
            // 将输入字段名的首字母改为大写 再次判断是否存在
            char[] ch = fieldName.toCharArray();
            if (fieldName.length() > 0 && ch[0] >= 'a' && ch[0] <= 'z') {
                ch[0] = (char) (ch[0] - 32);
            }
            String newFieldName = String.valueOf(ch);
            if (ruleMap.containsKey(newFieldName)) {
                result = ruleMap.get(newFieldName).getAttributeNum(strFieldValue);
            } else {
                throw new Exception("规则中不存在字段名：\t" + fieldName);
            }
        }
        return result;
    }
}
