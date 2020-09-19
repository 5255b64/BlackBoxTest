package edu.ecnu.sqslab.feature;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.sqslab.rules.IRule;
import edu.ecnu.sqslab.rules.discrete.DiscreteRule;
import edu.ecnu.sqslab.rules.discrete.FieldRule;
import edu.ecnu.sqslab.util.CombinationPair;
import edu.ecnu.sqslab.util.MyPair;

import java.util.*;

import static edu.ecnu.sqslab.Config.DEFAULT_FEATURE_VALUE_INVALID;

public class CstpFeatureParser extends AFeatureParser implements IFeatureParser {
    public CstpFeatureParser(IRule oldRuld) {
        this.oldRuld = oldRuld;
        this.dRule = new DiscreteRule(oldRuld);
        vectorMap = null;
    }

    public CstpFeatureParser(DiscreteRule dRule) {
        this.oldRuld = null;
        this.dRule = dRule;
        vectorMap = null;
    }

    /**
     * 处理测试用例
     * 将测试用例的“字段-取值”映射为
     * Map<String, String>类型的Map
     *
     * @param testcaseStr 测试用例输入
     * @return Map<String, String>类型的Map
     * 表示测试用例的“字段-取值”关系
     */
    @Override
    public Map<String, String> testcaseParserStrMap(String testcaseStr) {
        Map<String, String> result = new HashMap<>();
        JSONObject object = JSONObject.parseObject(testcaseStr);
        for (Map.Entry entry : object.entrySet()) {
            for (Map.Entry fieldObejct : ((JSONObject) entry.getValue()).entrySet()) {
                // 首字母大写
                String fieldName = (String) fieldObejct.getKey();
                String fieldValue = (String) fieldObejct.getValue();
                char[] ch = fieldName.toCharArray();
                if (fieldName.length() > 0 && ch[0] >= 'a' && ch[0] <= 'z') {
                    ch[0] = (char) (ch[0] - 32);
                }
                String newFieldName = String.valueOf(ch);
                result.put(newFieldName, fieldValue);
            }
        }
        return result;
    }
}
