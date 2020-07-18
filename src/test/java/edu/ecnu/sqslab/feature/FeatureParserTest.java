package edu.ecnu.sqslab.feature;

import edu.ecnu.sqslab.rules.SimpleTestRule;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FeatureParserTest {
    String simpleTestcaseStr = "{\n" +
            "    \"test.rule\": {\n" +
            "        \"A\": \"1\",\n" +
            "        \"B\": \"b\",\n" +
            "        \"C\": \"199\"\n" +
            "    }\n" +
            "}";

    @Test
    public void getFeatureTest() {
        FeatureParser parser = new CstpFeatureParser(new SimpleTestRule());
        List<Integer> result = null;
//        result = parser.getFeature(simpleTestcaseStr, 1);
//        System.out.println(result);
        result = parser.getFeature(simpleTestcaseStr, 2);
        System.out.println(result);
    }

}