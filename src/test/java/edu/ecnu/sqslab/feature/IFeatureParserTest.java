package edu.ecnu.sqslab.feature;

import edu.ecnu.sqslab.rules.FxDealLogRules;
import edu.ecnu.sqslab.rules.SimpleTestRule;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IFeatureParserTest {
    String simpleTestcaseStr = "{\n" +
            "    \"test.rule\": {\n" +
            "        \"A\": \"1\",\n" +
            "        \"B\": \"b\",\n" +
            "        \"C\": \"199\"\n" +
            "    }\n" +
            "}";
    String acturalTestcaseStr = "{\"cn.com.cfets.data.coretransaction.fx.DealLog\":{\"makerDealtCurrencyClearingBeneficiaryBankAccountNumber\":\"\",\"makerDealtCurrencyClearingIntermediaryBankBicCode\":\"otqFDEG6\",\"makerDealtCurrencyClearingIntermediaryBankAccountNumber\":\"\",\"makerDealtCurrencyClearingIntermediaryBankName\":\"t\",\"makerContraCurrencyClearingOpeningBankBicCode\":\"\",\"makerContraCurrencyClearingOpeningBankName\":\"U0o5QPo5hp\",\"makerContraCurrencyClearingOpeningBankAccountNumber\":\"\",\"makerContraCurrencyClearingRemark\":\"Hb\",\"makerContraCurrencyClearingBeneficiaryBankName\":\"gBQzgMOUpM\",\"makerContraCurrencyClearingBeneficiaryBankBicCode\":\"jYBnunEPG\",\"makerContraCurrencyClearingBeneficiaryBankAccountNumber\":\"u\",\"makerContraCurrencyClearingIntermediaryBankName\":\"\",\"makerContraCurrencyClearingIntermediaryBankBicCode\":\"\",\"makerContraCurrencyClearingIntermediaryBankAccountNumber\":\"dzkSuyWQ\",\"takerAgencyInstitutionCode\":\"\",\"accessMethod\":\"oJAzcY3G\",\"floorType\":\"\",\"takerOrderCode\":\"\",\"quoteInstitutionOrderCode\":\"\",\"quoteInstitutionAgencyInstitutionCode\":\"\",\"initiatorNearLegBaseCurrencyTradingDirection\":\"e7t\",\"initiatorFarLegBaseCurrencyDirection\":\"1\",\"takerDealtCurrencyClearingCapitalBankName\":\"Sfo80rx\",\"makerDealtCurrencyClearingCapitalBankName\":\"n\",\"takerContraCurrencyClearingCapitalBankName\":\"\",\"makerContraCurrencyClearingCapitalBankName\":\"\",\"takerDealtCurrencyClearingCapitalAccountName\":\"D4N\",\"makerDealtCurrencyClearingCapitalAccountName\":\"\",\"takerContraCurrencyClearingCapitalAccountName\":\"\",\"makerContraCurrencyClearingCapitalAccountName\":\"\",\"takerDealtCurrencyClearingPaymentSystemCode\":\"B70M\",\"makerDealtCurrencyClearingPaymentSystemCode\":\"M\",\"makerContraCurrencyClearingPaymentSystemCode\":\"\",\"takerContraCurrencyClearingPaymentSystemCode\":\"\",\"takerDealtCurrencyClearingCapitalAccountNumber\":\"1T\",\"makerDealtCurrencyClearingCapitalAccountNumber\":\"\",\"makerContraCurrencyClearingCapitalAmountNumber\":\"al\",\"takerContraCurrencyClearingCapitalAccountNumber\":\"TLuJQeb3tn\",\"productCode\":\"FXSWP\",\"clearingMethod\":\"\",\"period\":\"\",\"dealtCurrency\":\"\",\"contraCurrency\":\"1\",\"spotValueDate\":\"1304-04-04 23:04:14.052\",\"nearlegBaseAmount\":\"5715603\",\"nearlegTermAmount\":\"6\",\"nearlegRiskAmount\":\"1\",\"nearlegTerm\":\"SN\",\"nearlegValueDate\":\"\",\"farlegTerm\":\"TN\",\"farlegValueDate\":\"\",\"farlegBaseAmount\":\"5\",\"farlegTermAmount\":\"32458\",\"farlegRiskAmount\":\"75730\",\"netLiquidationForwardPricingDate\":\"\",\"quoteCode\":\"\",\"quoteRequestCode\":\"\",\"tradingStatus\":\"\",\"dealCode\":\"\",\"dealTime\":\"1826-08-04 06:06:13.155\",\"dealStatus\":\"1\",\"transactionDate\":\"1326-01-26 21:55:21.532\",\"baseCurrency\":\"\",\"termCurrency\":\"\",\"currencyPairType\":\"\",\"dateConfirmed\":\"\",\"tradeConfirmIndicator\":\"N\",\"optionSpotIndicator\":\"r6tTM\",\"chineseShortName\":\"\",\"englishShortName\":\"tA1iA\",\"quotingInstitutionCode\":\"\",\"quoteInstitutionTraderCode\":\"\",\"initiatorInstitutionCode\":\"\",\"takerTraderCode\":\"\",\"takerDirection\":\"\",\"optionDealCode\":\"BUIufJmho\",\"currencyPairCode\":\"AUX/CNY\",\"nearlegTransactionAllPrice\":\"8475\",\"farlegTransactionAllPrice\":\"\",\"takerInstitutionChineseFullName\":\"\",\"takerCfetsInstitutionCode\":\"I\",\"swapPoint\":\"\",\"contractName\":\"\",\"tradingMode\":\"C-Forward\",\"tradingModeCode\":\"\",\"quoteInstitutionLegalGroupName\":\"\",\"optionStrategyCode\":\"7zsXq\",\"farLegContraAmount\":\"\",\"nearLegContraAmount\":\"\",\"farLegDealtAmount\":\"6927526846\",\"nearLegDealtAmount\":\"4062\",\"takerLegalGroupName\":\"\",\"takerInstitutionEnglishFullName\":\"\",\"nearLegForwardPoint\":\"\",\"farLegForwardPoint\":\"\",\"nearLegSpotExchangeRate\":\"5\",\"farLegSpotExchangeRate\":\"8504106261\",\"takerDealtCurrencyClearingOpeningBankBicCode\":\"GFJ\",\"takerDealtCurrencyClearingOpeningBankName\":\"l\",\"takerContraCurrencyClearingOpeningBankName\":\"\",\"takerContraCurrencyClearingOpeningBankBicCode\":\"OqdTkG\",\"takerContraCurrencyClearingBeneficiaryBankName\":\"yzPJNhhgRO\",\"takerDealtCurrencyClearingOpeningBankAccountNumber\":\"\",\"takerContraCurrencyClearingOpeningBankAccountNumber\":\"w3TXO1m\",\"takerDealtCurrencyClearingRemark\":\"RmG7My\",\"takerContraCurrencyClearingRemark\":\"ba7ep\",\"quoteInstitutionChineseFullName\":\"\",\"quoteInstitutionCfetsInstitutionCode\":\"I\",\"quoteInstitutionEnglishFullName\":\"6XOy\",\"takerInstitutionEnglishShortName\":\"rV\",\"takerInstitutionChineseShortName\":\"\",\"tradingMethodCode\":\"ESP\",\"optionHedgeSpotForwardIndicator\":\"1\",\"takerFloorCode\":\"\",\"quoteInstitutionFloorCode\":\"wJI1oMU6Ts\",\"takerDealtCurrencyClearingBeneficiaryBankName\":\"Q9Lucbn\",\"takerDealtCurrencyClearingBeneficiaryBankBicCode\":\"s0Slo1JS3\",\"takerDealtCurrencyClearingBeneficiaryBankAccountNumber\":\"s\",\"takerDealtCurrencyClearingIntermediaryBankName\":\"\",\"takerDealtCurrencyClearingIntermediaryBankBicCode\":\"geq\",\"takerDealtCurrencyClearingIntermediaryBankAccountNumber\":\"\",\"takerContraCurrencyClearingBeneficiaryBankBicCode\":\"MryZ3nC\",\"takerContraCurrencyClearingBeneficiaryBankAccountNumber\":\"\",\"takerContraCurrencyClearingIntermediaryBankName\":\"\",\"takerContraCurrencyClearingIntermediaryBankBicCode\":\"\",\"takerContraCurrencyClearingIntermediaryBankAccountNumber\":\"\",\"makerDealtCurrencyClearingOpeningBankBicCode\":\"f\",\"makerDealtCurrencyClearingOpeningBankName\":\"\",\"makerDealtCurrencyClearingOpeningBankAccountNumber\":\"\",\"makerDealtCurrencyClearingRemark\":\"sJEzu6v7e\",\"makerDealtCurrencyClearingBeneficiaryBankName\":\"O7Mhngni\",\"optionReferenceExchangeRate\":\"5\",\"clearingCurrency\":\"\",\"productType\":\"M95YSs\",\"rndfPricingDate\":\"1253-02-07 04:10:39.733\",\"fixingRule\":\"aPS5JDJt\",\"fixingDateAdjustmentRule\":\"\",\"nettingAmount\":\"\",\"paymentMode\":\"\",\"referenceExchangeRate\":\"\",\"makerDealtCurrencyClearingBeneficiaryBankBicCode\":\"\"}}";

    @Test
    public void getFeatureTest1() {
        String result = "[0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0]";
        IFeatureParser parser = new CstpFeatureParser(new SimpleTestRule());
        List<Integer> output = parser.getFeature(simpleTestcaseStr, 1);
        assertEquals(result, output.toString());
    }

    @Test
    public void getFeatureTest2() {
        String result = "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]";
        IFeatureParser parser = new CstpFeatureParser(new SimpleTestRule());
        List<Integer> output = parser.getFeature(simpleTestcaseStr, 2);
        assertEquals(result, output.toString());
    }

    @Test
    public void getFeatureTest3() {
        String result = "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
        IFeatureParser parser = new CstpFeatureParser(new SimpleTestRule());
        List<Integer> output = parser.getFeature(simpleTestcaseStr, 3);
        assertEquals(result, output.toString());
    }

    @Test
    public void getFeatureTest4() {
        String result = "[0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0]";
        IFeatureParser parser = new CstpFeatureParser(new FxDealLogRules());
        List<Integer> output = parser.getFeature(acturalTestcaseStr, 1);
        assertEquals(result, output.toString());
    }
}