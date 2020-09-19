package edu.ecnu.sqslab.rules;

import org.junit.jupiter.api.Test;

class AbstructRuleTest {
    @Test
    public void getRuleListTest(){
        ARule x = new FxclDealLogRules();
        System.out.println(x.getRuleMap());
    }

    @Test
    public void getRuleListTest2(){
//        ARule rule = new SimpleTestRule();
        System.out.println(IRule.getRuleMap(new SimpleTestRule()));
    }
    @Test
    public void getRuleListTest3(){
        System.out.println(IRule.getRuleMap(new BcbipType1Rule()));
    }
}