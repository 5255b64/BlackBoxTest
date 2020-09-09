package edu.ecnu.sqslab.rules.discrete;

import org.junit.jupiter.api.Test;

import static edu.ecnu.sqslab.Config.DEFAULT_FEATURE_BLANK;
import static edu.ecnu.sqslab.Config.DEFAULT_FEATURE_VALUE_NO_RULE;
import static org.junit.jupiter.api.Assertions.*;

class FieldRuleTest {
    @Test
    public void test1(){
        FieldRule fr = new FieldRule("1,2,3,4~6,0.1~0.111,-3~-1,-0.111~-0.1", 0);
        System.out.println(fr);
        assertEquals(" #BLANK# #OUT_OF_RULE# 1 2 3 4.0~6.0 0.1~0.111 -3.0~-1.0 -0.111~-0.1", fr);
    }

    @Test
    public void test2(){
        FieldRule fr = new FieldRule("1,2,3,4~6,0.1~0.111,-3~-1,-0.111~-0.1", 0);
        // 空白输入
        assertEquals(DEFAULT_FEATURE_BLANK, fr.getAttributeNum(""));
        // 规则之外
        assertEquals(DEFAULT_FEATURE_VALUE_NO_RULE, fr.getAttributeNum("-999"));
        // 正常输入
        assertEquals(2, fr.getAttributeNum("1"));
        assertEquals(3, fr.getAttributeNum("2"));
        assertEquals(4, fr.getAttributeNum("3"));
        assertEquals(5, fr.getAttributeNum("4"));
        assertEquals(5, fr.getAttributeNum("5"));
        assertEquals(5, fr.getAttributeNum("6"));
        assertEquals(6, fr.getAttributeNum("0.1"));
        assertEquals(6, fr.getAttributeNum("0.101"));
        assertEquals(7, fr.getAttributeNum("-3"));
        assertEquals(7, fr.getAttributeNum("-2"));
        assertEquals(7, fr.getAttributeNum("-1"));
        assertEquals(8, fr.getAttributeNum("-0.111"));
        assertEquals(8, fr.getAttributeNum("-0.101"));
        assertEquals(8, fr.getAttributeNum("-0.1"));
    }
}