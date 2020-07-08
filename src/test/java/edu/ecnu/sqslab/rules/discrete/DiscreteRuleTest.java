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
}