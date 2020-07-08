package edu.ecnu.sqslab.rules;

public class FxOptionDealLogRules extends ARule implements IRule {

	public static String OptionStrategyType = "1,2,3,4,5,6,7,8";
	public static String ExerciseStatus = "1,2";
	public static String OptionStrategyCode = "";
	public static String SpotExchangeRate = "";
	public static String ForwardPoint = "";
	public static String DateConfirmed = "";
	public static String DealStatus = "3,1,2,VL_DT_ADJ_F";
	public static String DealCode = "";
	public static String TradeConfirmIndicator = "";
	public static String OptionStrategyDirection = "B,S";
	public static String TransactionDate = "";
	public static String DealTime = "";
	public static String TradingStatus = "";
	public static String TradingMethodCode = "Matching,RFQ,ESP";
	public static String TradingModeCode = "QDM,NDM,ODM";
	public static String TradingMode = "2,1,9";
	public static String HedgeDealCode = "";
	public static String ClearingMethod = "1,2,3";
	public static String OptionReferenceExchangeRate = "1,2,3,4,5";
	public static String ExerciseType = "1,2";
	public static String TakerDirection = "B,S";
	public static String TradingType = "Call,Put";
	public static String CurrencyPairCode = "JPY/CNY";
	public static String ExercisePrice = "";
	public static String ImpliedVolatility = "";
	public static String RiskAmount = "";
	public static String MaturityDate = "";
	public static String ExerciseCutOffTime = "";
	public static String TimeZone = "";
	public static String Period = "Broken";
	public static String DealtCurrency = "";
	public static String ContraCurrency = "";
	public static String DealtAmount = "";
	public static String PremiumType = "";
	public static String PremiumRate = "";
	public static String OptionPremiumPaymentCurrency = "";
	public static String OptionPremium = "";
	public static String FeeRatePrecision = "";
	public static String PremiumDate = "";
	public static String ValueDate = "";
	public static String OptionStrategyImpliedVolatility = "";
	public static String OptionStrategyPremiumType = "1,2";
	public static String OptionStrategyPremiumRate = "";
	public static String OptionStrategyPremium = "";
	public static String DeliveryType = "";
	public static String DeliveryDate = "";
	public static String StrikeTime = "";
	public static String ExerciseUserCode = "";
	public static String OptionReferenceExchangeRateValue = "";
	public static String ContraAmount = "";
	public static String NettingAmount = "";
	public static String TakerCfetsInstitutionCode = "";
	public static String TakerTraderCode = "";
	public static String TakerInstitutionEnglishShortName = "";
	public static String TakerInstitutionEnglishFullName = "";
	public static String TakerDealtCurrencyClearingCapitalBankName = "";
	public static String TakerDealtCurrencyClearingCapitalAccountName = "";
	public static String TakerDealtCurrencyClearingPaymentSystemCode = "";
	public static String TakerDealtCurrencyClearingCapitalAccountNumber = "";
	public static String TakerDealtCurrencyClearingRemark = "";
	public static String TakerFloorCode = "";
	public static String QuoteInstitutionCfetsInstitutionCode = "";
	public static String QuoteInstitutionTraderCode = "";
	public static String EnglishShortName = "";
	public static String MakerDealtCurrencyClearingCapitalBankName = "";
	public static String MakerDealtCurrencyClearingCapitalAccountName = "";
	public static String MakerDealtCurrencyClearingPaymentSystemCode = "";
	public static String MakerDealtCurrencyClearingCapitalAccountNumber = "";
	public static String MakerDealtCurrencyClearingRemark = "";
	public static String QuoteInstitutionFloorCode = "";
	public static String TakerDealtCurrencyClearingOpeningBankName = "";
	public static String TakerDealtCurrencyClearingOpeningBankBicCode = "";
	public static String TakerDealtCurrencyClearingOpeningBankAccountNumber = "";
	public static String TakerDealtCurrencyClearingBeneficiaryBankName = "";
	public static String TakerDealtCurrencyClearingBeneficiaryBankBicCode = "";
	public static String TakerDealtCurrencyClearingBeneficiaryBankAccountNumber = "";
	public static String TakerDealtCurrencyClearingIntermediaryBankName = "";
	public static String TakerDealtCurrencyClearingIntermediaryBankBicCode = "";
	public static String TakerDealtCurrencyClearingIntermediaryBankAccountNumber = "";
	public static String TakerContraCurrencyClearingCapitalBankName = "";
	public static String TakerContraCurrencyClearingCapitalAccountNumber = "";
	public static String TakerContraCurrencyClearingCapitalAccountName = "";
	public static String TakerContraCurrencyClearingPaymentSystemCode = "";
	public static String TakerContraCurrencyClearingRemark = "";
	public static String TakerContraCurrencyClearingOpeningBankName = "";
	public static String TakerContraCurrencyClearingOpeningBankBicCode = "";
	public static String TakerContraCurrencyClearingOpeningBankAccountNumber = "";
	public static String TakerContraCurrencyClearingBeneficiaryBankName = "";
	public static String TakerContraCurrencyClearingBeneficiaryBankBicCode = "";
	public static String TakerContraCurrencyClearingBeneficiaryBankAccountNumber = "";
	public static String TakerContraCurrencyClearingIntermediaryBankName = "";
	public static String TakerContraCurrencyClearingIntermediaryBankBicCode = "";
	public static String TakerContraCurrencyClearingIntermediaryBankAccountNumber = "";
	public static String QuoteInstitutionEnglishFullName = "";
	public static String MakerDealtCurrencyClearingOpeningBankName = "";
	public static String MakerDealtCurrencyClearingOpeningBankBicCode = "";
	public static String MakerDealtCurrencyClearingOpeningBankAccountNumber = "";
	public static String MakerDealtCurrencyClearingBeneficiaryBankName = "";
	public static String MakerDealtCurrencyClearingBeneficiaryBankBicCode = "";
	public static String MakerDealtCurrencyClearingBeneficiaryBankAccountNumber = "";
	public static String MakerDealtCurrencyClearingIntermediaryBankName = "";
	public static String MakerDealtCurrencyClearingIntermediaryBankBicCode = "";
	public static String MakerDealtCurrencyClearingIntermediaryBankAccountNumber = "";
	public static String MakerContraCurrencyClearingCapitalBankName = "";
	public static String MakerContraCurrencyClearingCapitalAmountNumber = "";
	public static String MakerContraCurrencyClearingCapitalAccountName = "";
	public static String MakerContraCurrencyClearingPaymentSystemCode = "";
	public static String MakerContraCurrencyClearingRemark = "";
	public static String MakerContraCurrencyClearingOpeningBankName = "";
	public static String MakerContraCurrencyClearingOpeningBankBicCode = "";
	public static String MakerContraCurrencyClearingOpeningBankAccountNumber = "";
	public static String MakerContraCurrencyClearingBeneficiaryBankName = "";
	public static String MakerContraCurrencyClearingBeneficiaryBankBicCode = "";
	public static String MakerContraCurrencyClearingBeneficiaryBankAccountNumber = "";
	public static String MakerContraCurrencyClearingIntermediaryBankName = "";
	public static String MakerContraCurrencyClearingIntermediaryBankBicCode = "";
	public static String MakerContraCurrencyClearingIntermediaryBankAccountNumber = "";
	public static String ExerciseDealCode = "";
}
