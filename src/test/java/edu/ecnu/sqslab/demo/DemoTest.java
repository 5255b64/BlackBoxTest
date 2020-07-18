package edu.ecnu.sqslab.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DemoTest {
    @Test
    public void mapDeepCopyTest(){
        Map<String, Integer> m1 = new HashMap();
        m1.put("a",1);
        m1.put("b",2);
        m1.put("c",3);
        System.out.println(m1);

        Map<String, Integer> m2 = new HashMap(m1);  // 拷贝构造
        System.out.println(m2);
        m2.put("d",4);
        System.out.println(m1);
        System.out.println(m2);
    }

    @Test
    public void mapModifyTest(){
        Map<String, Integer> m1 = new HashMap();
        m1.put("a",1);
        m1.put("b",2);
        m1.put("c",3);
        System.out.println(m1);

        m1.put("a", m1.get("a")+1);
        System.out.println(m1);
    }
}
