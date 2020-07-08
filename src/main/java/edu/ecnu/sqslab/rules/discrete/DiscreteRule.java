package edu.ecnu.sqslab.rules.discrete;

import edu.ecnu.sqslab.rules.IRule;

import java.util.HashMap;
import java.util.Map;

/**
 * 离散规则
 * 该规则下包含多个FieldRule
 */
public class DiscreteRule {
    public Map<String, FieldRule> ruleMap = null;

    public DiscreteRule(IRule oldRule){
        ruleMap = new HashMap<>();
        Map<String, String> oldRuleMap = oldRule.getRuleMap();
        for(Map.Entry<String, String> entry:oldRuleMap.entrySet()){
            String fieldName = entry.getKey();
            String fieldRule = entry.getValue();
            FieldRule fr = new FieldRule(fieldRule);
            ruleMap.put(fieldName,fr);
        }
    }

    public void print(){
        for(Map.Entry<String, FieldRule> entry:ruleMap.entrySet()) {
            System.out.println(entry.getKey()+":\t"+entry.getValue().toString());
        }
    }
    // TODO
}
