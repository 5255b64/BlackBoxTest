package edu.ecnu.sqslab.rules;

import java.util.List;

public class BcbipType3Rule extends ARule implements IRule {
    public static BaseIssueInfo baseIssueInfo;
    public static List<BaseBidInfoList> baseBidInfoList;
    public static BaseConstraint baseConstraint;

    static class BaseIssueInfo{
        public static String direction="买入,卖出";
        public static String priceType="价格";
        public static String isuSize="1";
        public static String minSize="";
    }
    static class BaseBidInfoList{
        public static String bidSrno="1,2,3,4,5";
        public static String bidOrg="工商银行";
        public static String bidOrgTp="BANK,AM,SOV,PF,INS,CORP,HF,PB,OTHER";
        public static String bidOrgRegion="APAC,EUROPE,MEA,AMER";
        public static String bidSize="10,11,13,14,15,20,25,26,30,31";
        public static String bidPrice="";
        public static String minBidSize="";
        public static String maxBidSize="";
        public static String isCarePrice="True,False";
        public static String priceLimit="";
        public static String bidDate="2020-06-16,2020-06-17,2020-06-20,2020-06-21,2020-06-23";
    }
    static class BaseConstraint{
        public static String isuSize="57,67,77,79,87,100";
        public static String priceTaget="";
        public static String syndicateOverflow="";
        public static String lotSize="0.2,1,3,7,10";
        public static String allocType="3";
        public static InvestRgConstraint investRgConstraint;

        static class InvestRgConstraint{
            public static String APAC="0,0.23,0.31,0.4,1";
            public static String EUROPE="0,0.11,0.19,0.08";
            public static String MEA="0,0.24,0.41,0.6,0.83";
            public static String AMER="0,0.19,0.71";
        }
    }
}
