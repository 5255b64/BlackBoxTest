package edu.ecnu.sqslab.rules;

import java.util.List;

public class BcbipType1Rule extends ARule implements IRule {
    static BaseIssueInfo baseIssueInfo;
    static List<BaseBidInfoList> baseBidInfoList;
    static BaseConstraint baseConstraint;

    class BaseIssueInfo{
        String direction="买入,卖出";
        String priceType="价格";
        String isuSize="1";
        String minSize="";
    }
    class BaseBidInfoList{
        String bidSrno="1,2,3,4,5";
        String bidOrg="工商银行";
        String bidOrgTp="BANK,AM,SOV,PF,INS,CORP,HF,PB,OTHER";
        String bidOrgRegion="APAC,EUROPE,MEA,AMER";
        String bidSize="10,11,13,14,15,20,25,26,30,31";
        String bidPrice="";
        String minBidSize="";
        String maxBidSize="";
        String isCarePrice="True,False";
        String priceLimit="";
        String bidDate="2020-06-16,2020-06-17,2020-06-20,2020-06-21,2020-06-23";
    }
    class BaseConstraint{
        String isuSize="57,67,77,79,87,100";
        String priceTaget="";
        String syndicateOverflow="";
        String lotSize="0.2,1,3,7,10";
        String allocType="1";
        InvestRgConstraint investRgConstraint;

        class InvestRgConstraint{
            String AM="";
            String BANK="";
            String SOV="";
            String PF="";
            String INS="";
            String CORP="";
            String HF="";
            String PB="";
            String OTHER="";
        }
    }
}
