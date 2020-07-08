package edu.ecnu.sqslab.rules;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class FxOptionDealLogRulesTest {
    @Test
    public void test1() {
        try {
            FxOptionDealLogRules obj = new FxOptionDealLogRules();
            Class c = obj.getClass();
            Field[] f = c.getFields();
            for (Field field : f) {
                System.out.println(field);

                String varName = field.getName();

                boolean access = field.isAccessible();
                if (!access) field.setAccessible(true);

                //从obj中获取field变量
                Object o = field.get(obj);
                System.out.println("变量： " + varName + " = " + o);

                if (!access) field.setAccessible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        IRule x = new FxOptionDealLogRules();
        System.out.println(x.getClass().getName());
    }

    @Test
    public void test3() {
        IRule x = new FxOptionDealLogRules();
        x.getRuleMap();
    }
}