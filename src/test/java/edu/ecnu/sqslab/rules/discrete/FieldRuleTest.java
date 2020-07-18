package edu.ecnu.sqslab.rules.discrete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldRuleTest {
    @Test
    public void test1(){
        FieldRule fr = new FieldRule("1,2,3,4~6,0.1~0.111,-3~-1,-0.111~-0.1", 0);
        System.out.println(fr);
    }

    @Test
    public void test2(){
        FieldRule fr = new FieldRule("1,2,3,4~6,0.1~0.111,-3~-1,-0.111~-0.1", 0);
        assertEquals(0, fr.getAttributeNum(""));
        assertEquals(1, fr.getAttributeNum("1"));
        assertEquals(2, fr.getAttributeNum("2"));
        assertEquals(3, fr.getAttributeNum("3"));
        assertEquals(4, fr.getAttributeNum("4"));
        assertEquals(4, fr.getAttributeNum("5"));
        assertEquals(4, fr.getAttributeNum("6"));
        assertEquals(5, fr.getAttributeNum("0.1"));
        assertEquals(5, fr.getAttributeNum("0.101"));
        assertEquals(6, fr.getAttributeNum("-3"));
        assertEquals(6, fr.getAttributeNum("-2"));
        assertEquals(6, fr.getAttributeNum("-1"));
        assertEquals(7, fr.getAttributeNum("-0.111"));
        assertEquals(7, fr.getAttributeNum("-0.101"));
        assertEquals(7, fr.getAttributeNum("-0.1"));
    }
}