package edu.ecnu.sqslab.testsuite;

import edu.ecnu.sqslab.LogParser;
import edu.ecnu.sqslab.feature.CstpFeatureParser;
import edu.ecnu.sqslab.feature.IFeatureParser;
import edu.ecnu.sqslab.rules.FxDealLogRules;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LogParserTest {
    private final static String dataToParse = "PROBE_ID 553 null\r\n" +
            "PROBE_ID 960 null\r\n" +
            "TEST_CASE_NUM 0\r\n" +
            "ACCURATE_PROBE cn.com.cfets.data.coretransaction.fx.DealLog <init> DealLog.java 126 1 ()V\r\n" +
            "ACCURATE_PROBE cn.com.cfets.data.coretransaction.fx.DealLog setBaseCurrency DealLog.java 1526 1 (Ljava/lang/String;)V\r\n"+
            "TEST_CASE {\"cn.com.cfets.data.coretransaction.fx.DealLog\":{\"makerDealtCurrencyClearingBeneficiaryBankAccountNumber\":\"\",\"makerDealtCurrencyClearingIntermediaryBankBicCode\":\"s\",\"makerDealtCurrencyClearingIntermediaryBankAccountNumber\":\"\",\"makerDealtCurrencyClearingIntermediaryBankName\":\"pD0giDSBS\",\"makerContraCurrencyClearingOpeningBankBicCode\":\"\",\"makerContraCurrencyClearingOpeningBankName\":\"BSHBn18Il\",\"makerContraCurrencyClearingOpeningBankAccountNumber\":\"9NRxWx7\",\"makerContraCurrencyClearingRemark\":\"\",\"makerContraCurrencyClearingBeneficiaryBankName\":\"\",\"makerContraCurrencyClearingBeneficiaryBankBicCode\":\"9JYUqRv\",\"makerContraCurrencyClearingBeneficiaryBankAccountNumber\":\"Ajh03Unh\",\"makerContraCurrencyClearingIntermediaryBankName\":\"\",\"makerContraCurrencyClearingIntermediaryBankBicCode\":\"j\",\"makerContraCurrencyClearingIntermediaryBankAccountNumber\":\"p\",\"takerAgencyInstitutionCode\":\"\",\"accessMethod\":\"\",\"floorType\":\"\",\"takerOrderCode\":\"\",\"quoteInstitutionOrderCode\":\"\",\"quoteInstitutionAgencyInstitutionCode\":\"\",\"initiatorNearLegBaseCurrencyTradingDirection\":\"1\",\"initiatorFarLegBaseCurrencyDirection\":\"\",\"takerDealtCurrencyClearingCapitalBankName\":\"\",\"makerDealtCurrencyClearingCapitalBankName\":\"f8d9djM\",\"takerContraCurrencyClearingCapitalBankName\":\"SNMlk\",\"makerContraCurrencyClearingCapitalBankName\":\"7xCkcuh0\",\"takerDealtCurrencyClearingCapitalAccountName\":\"ViB1\",\"makerDealtCurrencyClearingCapitalAccountName\":\"irr4khBfI\",\"takerContraCurrencyClearingCapitalAccountName\":\"\",\"makerContraCurrencyClearingCapitalAccountName\":\"\",\"takerDealtCurrencyClearingPaymentSystemCode\":\"\",\"makerDealtCurrencyClearingPaymentSystemCode\":\"\",\"makerContraCurrencyClearingPaymentSystemCode\":\"\",\"takerContraCurrencyClearingPaymentSystemCode\":\"\",\"takerDealtCurrencyClearingCapitalAccountNumber\":\"\",\"makerDealtCurrencyClearingCapitalAccountNumber\":\"\",\"makerContraCurrencyClearingCapitalAmountNumber\":\"\",\"takerContraCurrencyClearingCapitalAccountNumber\":\"\",\"productCode\":\"qyRBz9Q\",\"clearingMethod\":\"4\",\"period\":\"4Tgtq\",\"dealtCurrency\":\"\",\"contraCurrency\":\"\",\"spotValueDate\":\"1908-12-19 14:02:56.811\",\"nearlegBaseAmount\":\"\",\"nearlegTermAmount\":\"8946399704\",\"nearlegRiskAmount\":\"14\",\"nearlegTerm\":\"\",\"nearlegValueDate\":\"\",\"farlegTerm\":\"TN\",\"farlegValueDate\":\"\",\"farlegBaseAmount\":\"539\",\"farlegTermAmount\":\"\",\"farlegRiskAmount\":\"\",\"netLiquidationForwardPricingDate\":\"\",\"quoteCode\":\"\",\"quoteRequestCode\":\"\",\"tradingStatus\":\"\",\"dealCode\":\"G1vg26M\",\"dealTime\":\"\",\"dealStatus\":\"2\",\"transactionDate\":\"2776-01-30 06:53:34.501\",\"baseCurrency\":\"wl4FprB0\",\"termCurrency\":\"\",\"currencyPairType\":\"\",\"dateConfirmed\":\"2347-01-06 09:14:27.650\",\"tradeConfirmIndicator\":\"30A9j\",\"optionSpotIndicator\":\"1\",\"chineseShortName\":\"\",\"englishShortName\":\"skDiVgu\",\"quotingInstitutionCode\":\"\",\"quoteInstitutionTraderCode\":\"f\",\"initiatorInstitutionCode\":\"\",\"takerTraderCode\":\"\",\"takerDirection\":\"\",\"optionDealCode\":\"\",\"currencyPairCode\":\"\",\"nearlegTransactionAllPrice\":\"\",\"farlegTransactionAllPrice\":\"423\",\"takerInstitutionChineseFullName\":\"\",\"takerCfetsInstitutionCode\":\"\",\"swapPoint\":\"\",\"contractName\":\"\",\"tradingMode\":\"9\",\"tradingModeCode\":\"\",\"quoteInstitutionLegalGroupName\":\"\",\"optionStrategyCode\":\"fQdzLfjjF\",\"farLegContraAmount\":\"800\",\"nearLegContraAmount\":\"\",\"farLegDealtAmount\":\"392851\",\"nearLegDealtAmount\":\"7\",\"takerLegalGroupName\":\"\",\"takerInstitutionEnglishFullName\":\"kCTync\",\"nearLegForwardPoint\":\"\",\"farLegForwardPoint\":\"\",\"nearLegSpotExchangeRate\":\"\",\"farLegSpotExchangeRate\":\"\",\"takerDealtCurrencyClearingOpeningBankBicCode\":\"\",\"takerDealtCurrencyClearingOpeningBankName\":\"\",\"takerContraCurrencyClearingOpeningBankName\":\"18NL1Pi\",\"takerContraCurrencyClearingOpeningBankBicCode\":\"BdpmCbH\",\"takerContraCurrencyClearingBeneficiaryBankName\":\"\",\"takerDealtCurrencyClearingOpeningBankAccountNumber\":\"Kti6VgvGZe\",\"takerContraCurrencyClearingOpeningBankAccountNumber\":\"\",\"takerDealtCurrencyClearingRemark\":\"\",\"takerContraCurrencyClearingRemark\":\"\",\"quoteInstitutionChineseFullName\":\"\",\"quoteInstitutionCfetsInstitutionCode\":\"5D6bATlv\",\"quoteInstitutionEnglishFullName\":\"2Up\",\"takerInstitutionEnglishShortName\":\"\",\"takerInstitutionChineseShortName\":\"\",\"tradingMethodCode\":\"tp\",\"optionHedgeSpotForwardIndicator\":\"2\",\"takerFloorCode\":\"\",\"quoteInstitutionFloorCode\":\"\",\"takerDealtCurrencyClearingBeneficiaryBankName\":\"\",\"takerDealtCurrencyClearingBeneficiaryBankBicCode\":\"\",\"takerDealtCurrencyClearingBeneficiaryBankAccountNumber\":\"\",\"takerDealtCurrencyClearingIntermediaryBankName\":\"\",\"takerDealtCurrencyClearingIntermediaryBankBicCode\":\"\",\"takerDealtCurrencyClearingIntermediaryBankAccountNumber\":\"lXIE\",\"takerContraCurrencyClearingBeneficiaryBankBicCode\":\"fVXR\",\"takerContraCurrencyClearingBeneficiaryBankAccountNumber\":\"qjbshgUMQ\",\"takerContraCurrencyClearingIntermediaryBankName\":\"\",\"takerContraCurrencyClearingIntermediaryBankBicCode\":\"hi\",\"takerContraCurrencyClearingIntermediaryBankAccountNumber\":\"BL09\",\"makerDealtCurrencyClearingOpeningBankBicCode\":\"gxjS\",\"makerDealtCurrencyClearingOpeningBankName\":\"RJ\",\"makerDealtCurrencyClearingOpeningBankAccountNumber\":\"\",\"makerDealtCurrencyClearingRemark\":\"\",\"makerDealtCurrencyClearingBeneficiaryBankName\":\"\",\"optionReferenceExchangeRate\":\"2\",\"clearingCurrency\":\"cZ8Mvxb\",\"productType\":\"Zp\",\"rndfPricingDate\":\"\",\"fixingRule\":\"1H\",\"fixingDateAdjustmentRule\":\"\",\"nettingAmount\":\"\",\"paymentMode\":\"3qcDfXuoLQ\",\"referenceExchangeRate\":\"\",\"makerDealtCurrencyClearingBeneficiaryBankBicCode\":\"\"}}\r\n"+
            "1566194570862 FXCSTP-old accurateteststake___10675___end\r\n" +
            "ACCURATE_PROBE cn.com.cfets.data.coretransaction.fx.DealLog getDealCode DealLog.java 1442 1 ()Ljava/lang/String;\r\n"+
            "TEST_CASE_NUM 8\r\n"+
            "ACCURATE_PROBE cn.com.cfets.data.coretransaction.fx.DealLog <init> DealLog.java 126 1 ()V\r\n";


    @Test
    void parseLineTest() {
        LogParser lp = new LogParser(new TestSuiteManager());
        lp.parse(dataToParse);
        lp.printTestSuite();
    }
    @Test
    void parseLineTest2() {
        LogParser lp = new LogParser(new TestSuiteManager());
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\GX\\Study\\ECNU\\小论文\\程序\\Code\\src\\main\\resources\\log_cstp_6_25.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                lp.parse(str);
            }
            lp.printTestSuite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllTestcaseFeatureTest1() {
        LogParser lp = new LogParser(new TestSuiteManager());
        IFeatureParser parser = new CstpFeatureParser(new FxDealLogRules());
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\GX\\Study\\ECNU\\小论文\\程序\\Code\\src\\main\\resources\\log_cstp_6_25.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                lp.parse(str);
            }
            lp.getAllTestcaseFeature(parser,1);
            lp.printTestSuite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}