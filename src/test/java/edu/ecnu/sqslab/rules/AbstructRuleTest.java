package edu.ecnu.sqslab.rules;

import org.junit.jupiter.api.Test;

class AbstructRuleTest {
    @Test
    public void getRuleListTest(){
        ARule x = new FxclDealLogRules();
        System.out.println(x.getRuleMap());
    }
}