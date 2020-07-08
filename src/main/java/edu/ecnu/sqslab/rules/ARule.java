package edu.ecnu.sqslab.rules;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class ARule implements IRule {
    /**
     *
     * @return 返回HashMap 具体rule对象的所有成员变量名与变量值（类型全为String）
     */
    public Map<String,String> getRuleMap(){
        Map<String,String> result = new HashMap<>();
        try {
            IRule obj = this;
            Class c = obj.getClass();
            Field[] f = c.getFields();
            for (Field field : f) {
//                System.out.println(field);

                String varName = field.getName();

                boolean access = field.isAccessible();
                if (!access) field.setAccessible(true);

                //从obj中获取field变量
                String value = (String)field.get(obj);
//                System.out.println("变量： " + varName + " = " + value);
                result.put(varName, value);

                if (!access) field.setAccessible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
