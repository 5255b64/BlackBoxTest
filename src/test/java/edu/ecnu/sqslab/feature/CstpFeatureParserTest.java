package edu.ecnu.sqslab.feature;

import edu.ecnu.sqslab.rules.FxDealLogRules;
import edu.ecnu.sqslab.rules.SimpleTestRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class CstpFeatureParserTest {
    String simpleTestcaseStr = "{\n" +
            "    \"test.rule\": {\n" +
            "        \"A\": \"1\",\n" +
            "        \"B\": \"b\",\n" +
            "        \"C\": \"199\"\n" +
            "    }\n" +
            "}";
    String acturalTestcaseStr = "{\"cn.com.cfets.data.coretransaction.fx.DealLog\":{\"makerDealtCurrencyClearingBeneficiaryBankAccountNumber\":\"\",\"makerDealtCurrencyClearingIntermediaryBankBicCode\":\"otqFDEG6\",\"makerDealtCurrencyClearingIntermediaryBankAccountNumber\":\"\",\"makerDealtCurrencyClearingIntermediaryBankName\":\"t\",\"makerContraCurrencyClearingOpeningBankBicCode\":\"\",\"makerContraCurrencyClearingOpeningBankName\":\"U0o5QPo5hp\",\"makerContraCurrencyClearingOpeningBankAccountNumber\":\"\",\"makerContraCurrencyClearingRemark\":\"Hb\",\"makerContraCurrencyClearingBeneficiaryBankName\":\"gBQzgMOUpM\",\"makerContraCurrencyClearingBeneficiaryBankBicCode\":\"jYBnunEPG\",\"makerContraCurrencyClearingBeneficiaryBankAccountNumber\":\"u\",\"makerContraCurrencyClearingIntermediaryBankName\":\"\",\"makerContraCurrencyClearingIntermediaryBankBicCode\":\"\",\"makerContraCurrencyClearingIntermediaryBankAccountNumber\":\"dzkSuyWQ\",\"takerAgencyInstitutionCode\":\"\",\"accessMethod\":\"oJAzcY3G\",\"floorType\":\"\",\"takerOrderCode\":\"\",\"quoteInstitutionOrderCode\":\"\",\"quoteInstitutionAgencyInstitutionCode\":\"\",\"initiatorNearLegBaseCurrencyTradingDirection\":\"e7t\",\"initiatorFarLegBaseCurrencyDirection\":\"1\",\"takerDealtCurrencyClearingCapitalBankName\":\"Sfo80rx\",\"makerDealtCurrencyClearingCapitalBankName\":\"n\",\"takerContraCurrencyClearingCapitalBankName\":\"\",\"makerContraCurrencyClearingCapitalBankName\":\"\",\"takerDealtCurrencyClearingCapitalAccountName\":\"D4N\",\"makerDealtCurrencyClearingCapitalAccountName\":\"\",\"takerContraCurrencyClearingCapitalAccountName\":\"\",\"makerContraCurrencyClearingCapitalAccountName\":\"\",\"takerDealtCurrencyClearingPaymentSystemCode\":\"B70M\",\"makerDealtCurrencyClearingPaymentSystemCode\":\"M\",\"makerContraCurrencyClearingPaymentSystemCode\":\"\",\"takerContraCurrencyClearingPaymentSystemCode\":\"\",\"takerDealtCurrencyClearingCapitalAccountNumber\":\"1T\",\"makerDealtCurrencyClearingCapitalAccountNumber\":\"\",\"makerContraCurrencyClearingCapitalAmountNumber\":\"al\",\"takerContraCurrencyClearingCapitalAccountNumber\":\"TLuJQeb3tn\",\"productCode\":\"FXSWP\",\"clearingMethod\":\"\",\"period\":\"\",\"dealtCurrency\":\"\",\"contraCurrency\":\"1\",\"spotValueDate\":\"1304-04-04 23:04:14.052\",\"nearlegBaseAmount\":\"5715603\",\"nearlegTermAmount\":\"6\",\"nearlegRiskAmount\":\"1\",\"nearlegTerm\":\"SN\",\"nearlegValueDate\":\"\",\"farlegTerm\":\"TN\",\"farlegValueDate\":\"\",\"farlegBaseAmount\":\"5\",\"farlegTermAmount\":\"32458\",\"farlegRiskAmount\":\"75730\",\"netLiquidationForwardPricingDate\":\"\",\"quoteCode\":\"\",\"quoteRequestCode\":\"\",\"tradingStatus\":\"\",\"dealCode\":\"\",\"dealTime\":\"1826-08-04 06:06:13.155\",\"dealStatus\":\"1\",\"transactionDate\":\"1326-01-26 21:55:21.532\",\"baseCurrency\":\"\",\"termCurrency\":\"\",\"currencyPairType\":\"\",\"dateConfirmed\":\"\",\"tradeConfirmIndicator\":\"N\",\"optionSpotIndicator\":\"r6tTM\",\"chineseShortName\":\"\",\"englishShortName\":\"tA1iA\",\"quotingInstitutionCode\":\"\",\"quoteInstitutionTraderCode\":\"\",\"initiatorInstitutionCode\":\"\",\"takerTraderCode\":\"\",\"takerDirection\":\"\",\"optionDealCode\":\"BUIufJmho\",\"currencyPairCode\":\"AUX/CNY\",\"nearlegTransactionAllPrice\":\"8475\",\"farlegTransactionAllPrice\":\"\",\"takerInstitutionChineseFullName\":\"\",\"takerCfetsInstitutionCode\":\"I\",\"swapPoint\":\"\",\"contractName\":\"\",\"tradingMode\":\"C-Forward\",\"tradingModeCode\":\"\",\"quoteInstitutionLegalGroupName\":\"\",\"optionStrategyCode\":\"7zsXq\",\"farLegContraAmount\":\"\",\"nearLegContraAmount\":\"\",\"farLegDealtAmount\":\"6927526846\",\"nearLegDealtAmount\":\"4062\",\"takerLegalGroupName\":\"\",\"takerInstitutionEnglishFullName\":\"\",\"nearLegForwardPoint\":\"\",\"farLegForwardPoint\":\"\",\"nearLegSpotExchangeRate\":\"5\",\"farLegSpotExchangeRate\":\"8504106261\",\"takerDealtCurrencyClearingOpeningBankBicCode\":\"GFJ\",\"takerDealtCurrencyClearingOpeningBankName\":\"l\",\"takerContraCurrencyClearingOpeningBankName\":\"\",\"takerContraCurrencyClearingOpeningBankBicCode\":\"OqdTkG\",\"takerContraCurrencyClearingBeneficiaryBankName\":\"yzPJNhhgRO\",\"takerDealtCurrencyClearingOpeningBankAccountNumber\":\"\",\"takerContraCurrencyClearingOpeningBankAccountNumber\":\"w3TXO1m\",\"takerDealtCurrencyClearingRemark\":\"RmG7My\",\"takerContraCurrencyClearingRemark\":\"ba7ep\",\"quoteInstitutionChineseFullName\":\"\",\"quoteInstitutionCfetsInstitutionCode\":\"I\",\"quoteInstitutionEnglishFullName\":\"6XOy\",\"takerInstitutionEnglishShortName\":\"rV\",\"takerInstitutionChineseShortName\":\"\",\"tradingMethodCode\":\"ESP\",\"optionHedgeSpotForwardIndicator\":\"1\",\"takerFloorCode\":\"\",\"quoteInstitutionFloorCode\":\"wJI1oMU6Ts\",\"takerDealtCurrencyClearingBeneficiaryBankName\":\"Q9Lucbn\",\"takerDealtCurrencyClearingBeneficiaryBankBicCode\":\"s0Slo1JS3\",\"takerDealtCurrencyClearingBeneficiaryBankAccountNumber\":\"s\",\"takerDealtCurrencyClearingIntermediaryBankName\":\"\",\"takerDealtCurrencyClearingIntermediaryBankBicCode\":\"geq\",\"takerDealtCurrencyClearingIntermediaryBankAccountNumber\":\"\",\"takerContraCurrencyClearingBeneficiaryBankBicCode\":\"MryZ3nC\",\"takerContraCurrencyClearingBeneficiaryBankAccountNumber\":\"\",\"takerContraCurrencyClearingIntermediaryBankName\":\"\",\"takerContraCurrencyClearingIntermediaryBankBicCode\":\"\",\"takerContraCurrencyClearingIntermediaryBankAccountNumber\":\"\",\"makerDealtCurrencyClearingOpeningBankBicCode\":\"f\",\"makerDealtCurrencyClearingOpeningBankName\":\"\",\"makerDealtCurrencyClearingOpeningBankAccountNumber\":\"\",\"makerDealtCurrencyClearingRemark\":\"sJEzu6v7e\",\"makerDealtCurrencyClearingBeneficiaryBankName\":\"O7Mhngni\",\"optionReferenceExchangeRate\":\"5\",\"clearingCurrency\":\"\",\"productType\":\"M95YSs\",\"rndfPricingDate\":\"1253-02-07 04:10:39.733\",\"fixingRule\":\"aPS5JDJt\",\"fixingDateAdjustmentRule\":\"\",\"nettingAmount\":\"\",\"paymentMode\":\"\",\"referenceExchangeRate\":\"\",\"makerDealtCurrencyClearingBeneficiaryBankBicCode\":\"\"}}";

    @Test
    public void getInputFieldMapTest() {
        CstpFeatureParser parser = new CstpFeatureParser(new FxDealLogRules());
        System.out.println(parser.testcaseParserStrMap(acturalTestcaseStr));
    }

    @Test
    public void testcaseParserIntMapTest() {
        String result = "{0=0, 1=1, 2=1, 3=0, 4=3, 5=1, 6=0, 7=11, 8=1, 9=1, 10=0, 11=1, 12=1, 13=1, 14=4, 15=1, 16=2, 17=0, 18=0, 19=1, 20=1, 21=1, 22=1, 23=1, 24=0, 25=0, 26=1, 27=1, 28=1, 29=1, 30=1, 31=0, 32=0, 33=0, 34=1, 35=1, 36=1, 37=1, 38=1, 39=1, 40=1, 41=4, 42=0, 43=1, 44=0, 45=1, 46=0, 47=0, 48=1, 49=1, 50=1, 51=1, 52=1, 53=1, 54=0, 55=0, 56=1, 57=5, 58=0, 59=0, 60=1, 61=1, 62=1, 63=0, 64=1, 65=0, 66=1, 67=0, 68=1, 69=1, 70=1, 71=0, 72=1, 73=2, 74=1, 75=0, 76=0, 77=1, 78=0, 79=0, 80=1, 81=1, 82=0, 83=0, 84=3, 85=0, 86=0, 87=1, 88=1, 89=0, 90=0, 91=0, 92=1, 93=0, 94=1, 95=2, 96=0, 97=1, 98=0, 99=0, 100=0, 101=1, 102=0, 103=2, 104=0, 105=1, 106=1, 107=0, 108=2, 109=0, 110=0, 111=0, 112=0, 113=1, 114=0, 115=1, 116=1, 117=1}";
        CstpFeatureParser parser = new CstpFeatureParser(new FxDealLogRules());
        Map<String, String> strMap = parser.testcaseParserStrMap(acturalTestcaseStr);
        Map<Integer, Integer> intMap = parser.testcaseParserIntMap(strMap);
        assertEquals(result, intMap.toString());
    }

    @Test
    public void getTestcaseCombinationTest(){
        CstpFeatureParser parser = new CstpFeatureParser(new SimpleTestRule());
        Map<String, String> strMap = parser.testcaseParserStrMap(simpleTestcaseStr);
        Map<Integer, Integer> intMap = parser.testcaseParserIntMap(strMap);
        parser.setNDimension(2);
        System.out.println(parser.getTestcaseCombination(intMap));
    }

    @Test
    public void setVectorTableTest(){
        CstpFeatureParser parser = new CstpFeatureParser(new SimpleTestRule());
        parser.setVectorTable(1);
        System.out.println(parser.vectorMap);
    }

}