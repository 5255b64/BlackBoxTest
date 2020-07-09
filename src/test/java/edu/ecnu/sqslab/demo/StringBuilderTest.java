package edu.ecnu.sqslab.demo;

import org.junit.jupiter.api.Test;

public class StringBuilderTest {
    @Test
    public void test1(){
        String data = "abc123";
//        char[] ca = data.toCharArray();
//        char[] tmp = ((String)" ").toCharArray();
//        StringBuilder newFieldName = new StringBuilder(data);
//        System.out.println(newFieldName.toString());
//        System.out.println(tmp);
//        newFieldName.getChars(0,1,tmp,0);
//        System.out.println(tmp);
//        StringBuffer sb = new StringBuffer(tmp.toString().toUpperCase());
        System.out.println(data);
        System.out.println(data.charAt(0));
        System.out.println(String.valueOf(data.charAt(0)));
        System.out.println(data.replaceFirst(String.valueOf(data.charAt(0)), String.valueOf(data.charAt(0))).toUpperCase());
    }
}
