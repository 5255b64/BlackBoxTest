package edu.ecnu.sqslab.rules.discrete;

import sun.awt.image.ImageWatched;

import java.util.*;

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
     * 二元组
     * 保存字段 取值的编号 和 取值规则
     */
    class Tuple {
        public int num;    // 字段取值编号
        public IValueRule vr;  // 字段取值规则

        public Tuple(int num, IValueRule vr) {
            this.num = num;
            this.vr = vr;
        }

        public String toString() {
//            return String.valueOf(num)+","+vr.toString();
            return vr.toString();
        }
    }
}
