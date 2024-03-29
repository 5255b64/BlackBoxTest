package edu.ecnu.sqslab.rules.discrete;


import static edu.ecnu.sqslab.Config.RULE_BLANK;

/**
 * 枚举值的规则
 */
public class ValueRuleEnum implements IValueRule {
    private String value = null;

    public ValueRuleEnum(String enumValue) {
        this.value = enumValue;
    }

    @Override
    public boolean isApply(String value) {
        try {
            return value.equals(this.value);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return false;
    }

    @Override
    public String toString() {
        if (value.equals("")) {
            return RULE_BLANK;
        } else {
            return value;
        }
    }
}
