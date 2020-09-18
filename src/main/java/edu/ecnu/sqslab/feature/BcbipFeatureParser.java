package edu.ecnu.sqslab.feature;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.sqslab.rules.IRule;
import edu.ecnu.sqslab.rules.discrete.DiscreteRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bcbip构件的特征提取器
 * 需要考虑规则中的类嵌套
 * 以及规则中的List嵌套
 */
public class BcbipFeatureParser extends AFeatureParser implements IFeatureParser {
    // TODO 参考CstpFeatureParser的代码
    public BcbipFeatureParser(IRule oldRuld) {
        this.oldRuld = oldRuld;
        this.dRule = new DiscreteRule(oldRuld);
        vectorMap = null;
    }

    public BcbipFeatureParser(DiscreteRule dRule) {
        this.oldRuld = null;
        this.dRule = dRule;
        vectorMap = null;
    }

    @Override
    public Map<String, String> testcaseParserStrMap(String testcaseStr) {
        // TODO 编写代码
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

    @Override
    public Map<Integer, Integer> testcaseParserIntMap(Map<String, String> testcaseStrMap) {
        // TODO 编写代码
        return null;
    }
}
