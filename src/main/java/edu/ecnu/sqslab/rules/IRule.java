package edu.ecnu.sqslab.rules;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRule {
    public Map<String,String> getRuleMap();

    /*
     * 例子：接口规则
     * 每个字段以一个成员变量的形式表示
     * 变量前缀均为 public static String
     * 变量名为字段名
     * 变量值为字符串 其规则如下
     * 空字符串“”：表示取值为 空/随机字符串
     * 单个字符串“abc”：表示取值为 空/随机字符串/给定字符串“abc”
     * 以逗号分隔的字符串"1,2,3":表示取值为 空/1/2/3
     * 以逗号分隔的字符串"1,2,3-5"，每个分隔中存在"a-b"的形式，表示范围: 取值为 空/1/2/3-5之间的数
     */
//    public static String ClearingMethod = "1,2,3";
    /**
     * 递归方法
     * 给定对象 Object obj 递归获取
     * @return 返回HashMap 具体rule对象的所有成员变量名与变量值（需要判断成员类型）
     */
    public static Map<String,String> getRuleMap(Object obj){
        Map<String,String> result = new HashMap<>();
        try {
//            IRule obj = this;
            Class c = obj.getClass();
            Field[] f = c.getFields();
            for (Field field : f) {
//                System.out.println(field);
                String varName = field.getName();
                // 首字母大写
                varName = varName.substring(0,1).toUpperCase()+varName.substring(1);
                boolean access = field.isAccessible();
                if (!access) field.setAccessible(true);
                // 从obj中获取field变量
                Object value = field.get(obj);
                // 判断field的类型
                if(field.getType().equals(String.class)){
//                System.out.println("变量： " + varName + " = " + value);
                    result.put(varName, (String)value);
                }else if(field.getType().equals(List.class)){
//                    System.out.println("List "+varName);
                    String className = c.getName()+"$"+varName.substring(0,1).toUpperCase()+varName.substring(1);
                    Map<String,String> map = getRuleMap(Class.forName(className).newInstance());
                    for(Map.Entry<String ,String> entry:map.entrySet()){
                        result.put(varName+"_"+entry.getKey(), entry.getValue());
                    }
                }else{
                    Map<String,String> map = getRuleMap(field.getType().newInstance());
                    for(Map.Entry<String ,String> entry:map.entrySet()){
                        result.put(varName+"_"+entry.getKey(), entry.getValue());
                    }
                }
                if (!access) field.setAccessible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
