package edu.ecnu.sqslab.rules.discrete;

import edu.ecnu.sqslab.rules.FxclDealLogRules;
import edu.ecnu.sqslab.rules.IRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscreteRuleTest {
    @Test
    public void test1(){
        IRule oldRule = new FxclDealLogRules();
        DiscreteRule dr = new DiscreteRule(oldRule);
        dr.print();
    }

    @Test
    public void test2(){
        IRule oldRule = new FxclDealLogRules();
        DiscreteRule dr = new DiscreteRule(oldRule);
        try {
            // 正常输入
            assertEquals(0, dr.getAttributeNum("QuoteInstitutionFloorCode", ""));
            // 输入值无法在规则中找到
            assertEquals(-1,dr.getAttributeNum("QuoteInstitutionFloorCode", "xxx"));
            // 输入字段名错误 抛出Exception
            assertThrows(Exception.class,()->dr.getAttributeNum("QuoteInstitutionFloorCode123", "xxx"));
        }catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}