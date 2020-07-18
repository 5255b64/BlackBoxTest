package edu.ecnu.sqslab.feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationTest {
    @Test
    public void test1(){
        Combination com = new Combination();
        com.add(1);
        com.add(2);
        com.add(3);
        com.add(3);
        System.out.println(com);
    }

    @Test
    public void checkTest(){
        Combination comOld = new Combination();
        comOld.add(1, 11);
        comOld.add(2, 12);
        assertEquals(0, comOld.getCombCount());
        Combination comNew = new Combination();
        comNew.add(1, 11);

        assertFalse(comOld.equals(comNew));
        assertEquals(0, comOld.getCombCount());

        comNew.add(2, 12);
        assertTrue(comOld.equals(comNew));
        assertEquals(1, comOld.getCombCount());
    }
}