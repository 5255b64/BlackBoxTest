package edu.ecnu.sqslab.rules.discrete;

import java.util.regex.Pattern;


/**
 * range值的规则
 */
public class ValueRuleRange implements IValueRule {
    private static final String PATTERN = "^(-?[0-9]+([.][0-9]+)?)~(-?[0-9]+([.][0-9]+)?)$";
    private Boolean isActive=false;     // 该规则是否有效
    private Double low= (double) 0;
    private Double high = (double) 0;

    public static boolean patternCheck(String rangeRule){
        return Pattern.matches(PATTERN, rangeRule);
    }

    public ValueRuleRange(String rangeRule) throws Exception {
        boolean formatChecker=false; // 标志 判断规则是否符合预期
        // 使用正则表达式匹配规则
        if(patternCheck(rangeRule)){
            String[] tmp=rangeRule.split("~");
            if(tmp.length==2){
                if(Double.parseDouble(tmp[0])<Double.parseDouble(tmp[1])) {
                    formatChecker = true;
                    // 判断最小值与最大值的规则是否正确
                    low=Double.parseDouble(tmp[0]);
                    high=Double.parseDouble(tmp[1]);
                }
            }
        }
        if(formatChecker){
            isActive=true;
        }else{
            isActive=false;
            throw new Exception("Range表达式:\""+rangeRule+"\"不匹配");
        }
    }


    @Override
    public boolean isApply(String value) throws Exception {
        if(isActive){
            double doubleValue = Double.parseDouble(value);
            return doubleValue >= low && doubleValue <= high;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.valueOf(low)+"~"+String.valueOf(high);
    }
}
