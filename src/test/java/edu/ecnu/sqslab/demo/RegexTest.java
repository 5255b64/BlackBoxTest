package edu.ecnu.sqslab.demo;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegexTest {
    @Test
    public void test1(){
        String content = "1~2\n" +
                "999~1000\n" +
                "-123~456\n" +
                "1.234~5678\n" +
                "-0.00000026~5678.999";

        String pattern = "(-?[0-9]+([.][0-9]+)?)~(-?[0-9]+([.][0-9]+)?)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(content);
        if(m.find()){
            for(int i=0;i<m.groupCount();i++)
            System.out.println(m.group(i));
        }
    }

    @Test
    public void test2(){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = "^(-?[0-9]+([.][0-9]+)?)~(-?[0-9]+([.][0-9]+)?)$";

        assertEquals(true, Pattern.matches(pattern, "1~2"));
        assertEquals(true, Pattern.matches(pattern, "999~1000"));
        assertEquals(true, Pattern.matches(pattern, "-123~456"));
        assertEquals(true, Pattern.matches(pattern, "1.234~5678"));
        assertEquals(true, Pattern.matches(pattern, "-0.00000026~5678.999"));
        assertEquals(false, Pattern.matches(pattern, ".00000026~5678.999"));
        assertEquals(false, Pattern.matches(pattern, "-.00000026~5678.999"));
    }
}
