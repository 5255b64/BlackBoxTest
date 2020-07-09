package edu.ecnu.sqslab.rules.discrete;

import java.util.*;

import static edu.ecnu.sqslab.Config.DEFAULT_FEATURE_VALUE_NO_RULE;

/**
 * 字段取值规则
 * 该规则下包含多个IValueRule
 * 构造对象时 要判断每个IValueRule是enum类型还是range类型
 */
public class FieldRule {
    private List<Tuple> fieldRuleList = null;
    private int ruleNum = 0;

    public FieldRule(String fieldRule) {
        String[] rules = fieldRule.split(",");
        fieldRuleList = new LinkedList<>();

        // 规则不为空的情况 添加一个空值
        if (!fieldRule.equals("")) {
            fieldRuleList.add(new Tuple(ruleNum++, new ValueRuleEnum("")));
        }

        for (String rule : rules) {
            IValueRule vr = null;
            if (ValueRuleRange.patternCheck(rule)) {
                try {
                    vr = new ValueRuleRange(rule);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            } else {
                vr = new ValueRuleEnum(rule);
            }
            fieldRuleList.add(new Tuple(ruleNum++, vr));
        }
    }

    public String toString() {
        String result = "";
        for (Tuple p : fieldRuleList) {
            result += " " + p.toString();
        }
        return result;
    }

    /**
     * 获取特征值
     * 判断给定值strFieldValue在字段规则FieldRule中对应的类别
     * 从fieldRuleList列表中遍历查询
     * 如果fieldRuleList中不存在该规则 则返回-1
     * @param strFieldValue 给定值
     * @return 若给定值strFieldValue符合fieldRuleList中某个Tuple的规则
     *         则返回对应Tuple的num
     *         若不存在符合的规则 则返回-1
     */
    public int getAttributeNum(String strFieldValue){
        int result = DEFAULT_FEATURE_VALUE_NO_RULE;    // 缺省值
        for(Tuple tmp:fieldRuleList){
            try {
                if(tmp.getVr().isApply(strFieldValue)){
                    result = tmp.getNum();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 二元组 TODO 使用MyPair来代替
     * 保存字段 取值的编号 和 取值规则
     */
    static class Tuple {
        private final int num;    // 字段取值编号
        private final IValueRule vr;  // 字段取值规则

        public Tuple(int num, IValueRule vr) {
            this.num = num;
            this.vr = vr;
        }

        public String toString() {
            return vr.toString();
        }

        public IValueRule getVr(){
            return this.vr;
        }

        public int getNum(){
            return this.num;
        }
    }
}
