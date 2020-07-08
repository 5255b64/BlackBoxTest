package edu.ecnu.sqslab.feature;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CstpTestcaseParser{
    public static Map<String, String> getFieldMap(String testcaseStr) {
        Map<String, String> result = new HashMap<>();
        JSONObject object = JSONObject.parseObject(testcaseStr);
        for(Map.Entry entry: object.entrySet()){
            for(Map.Entry fieldObejct: ((JSONObject)entry.getValue()).entrySet()){
                result.put((String)fieldObejct.getKey(), (String)fieldObejct.getValue());
            }
        }
        return result;
    }
}
