package edu.ecnu.sqslab.rules;

import edu.ecnu.sqslab.feature.BcbipFeatureParser;
import edu.ecnu.sqslab.feature.CstpFeatureParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BcbipType1RuleTest {
    final static String acturalTestcaseStr ="{\n" +
            "    \"baseIssueInfo\": {\n" +
            "        \"priceType\": \"价格\",\n" +
            "        \"isuSize\": \"1\",\n" +
            "        \"direction\": \"卖出\",\n" +
            "        \"minSize\": \"\"\n" +
            "    },\n" +
            "    \"baseConstraint\": {\n" +
            "        \"lotSize\": \"0.2\",\n" +
            "        \"isuSize\": \"67\",\n" +
            "        \"allocType\": \"3\",\n" +
            "        \"investRgConstraint\": {\n" +
            "            \"EUROPE\": \"0.19\",\n" +
            "            \"APAC\": \"0.31\",\n" +
            "            \"MEA\": \"0.83\",\n" +
            "            \"AMER\": \"0.71\"\n" +
            "        },\n" +
            "        \"priceTaget\": \"\",\n" +
            "        \"syndicateOverflow\": \"\"\n" +
            "    },\n" +
            "    \"baseBidInfoList\": [\n" +
            "        {\n" +
            "            \"bidDate\": \"2020-06-16\",\n" +
            "            \"minBidSize\": \"\",\n" +
            "            \"bidOrgTp\": \"CORP\",\n" +
            "            \"bidPrice\": \"\",\n" +
            "            \"bidOrg\": \"工商银行\",\n" +
            "            \"bidOrgRegion\": \"APAC\",\n" +
            "            \"bidSrno\": \"2\",\n" +
            "            \"bidSize\": \"30\",\n" +
            "            \"maxBidSize\": \"\",\n" +
            "            \"priceLimit\": \"\",\n" +
            "            \"isCarePrice\": \"True\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Test
    public void bcbipFeatureParserTest1(){
        // TODO
//        String result = "{0=0, 1=1, 2=1, 3=0, 4=3, 5=1, 6=0, 7=11, 8=1, 9=1, 10=0, 11=1, 12=1, 13=1, 14=4, 15=1, 16=2, 17=0, 18=0, 19=1, 20=1, 21=1, 22=1, 23=1, 24=0, 25=0, 26=1, 27=1, 28=1, 29=1, 30=1, 31=0, 32=0, 33=0, 34=1, 35=1, 36=1, 37=1, 38=1, 39=1, 40=1, 41=4, 42=0, 43=1, 44=0, 45=1, 46=0, 47=0, 48=1, 49=1, 50=1, 51=1, 52=1, 53=1, 54=0, 55=0, 56=1, 57=5, 58=0, 59=0, 60=1, 61=1, 62=1, 63=0, 64=1, 65=0, 66=1, 67=0, 68=1, 69=1, 70=1, 71=0, 72=1, 73=2, 74=1, 75=0, 76=0, 77=1, 78=0, 79=0, 80=1, 81=1, 82=0, 83=0, 84=3, 85=0, 86=0, 87=1, 88=1, 89=0, 90=0, 91=0, 92=1, 93=0, 94=1, 95=2, 96=0, 97=1, 98=0, 99=0, 100=0, 101=1, 102=0, 103=2, 104=0, 105=1, 106=1, 107=0, 108=2, 109=0, 110=0, 111=0, 112=0, 113=1, 114=0, 115=1, 116=1, 117=1}";
        BcbipFeatureParser parser = new BcbipFeatureParser(new BcbipType1Rule());
        Map<String, String> strMap = parser.testcaseParserStrMap(acturalTestcaseStr);
        Map<Integer, Integer> intMap = parser.testcaseParserIntMap(strMap);
        System.out.println("strMap: "+ strMap);
        System.out.println("intMap: "+ intMap);
//        assertEquals(result, intMap.toString());
    }

}