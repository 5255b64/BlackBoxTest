package edu.ecnu.sqslab.rules.discrete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldRuleTest {
    @Test
    public void test1(){
        FieldRule fr = new FieldRule("1,2,3,4~6,0.1-0.111,-3~-1,-0.111~-0.1");
        System.out.println(fr);
    }
}