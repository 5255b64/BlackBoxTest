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
}