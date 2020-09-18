package edu.ecnu.sqslab.rules;

import java.util.List;

public class BcbipType2Rule extends ARule implements IRule {
    BaseIssueInfo baseIssueInfo;
    List<BaseBidInfoList> baseBidInfoList;
    BaseConstraint baseConstraint;

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
        InvestTpConstraint investTpConstraint;

        class InvestTpConstraint{
            String AM="0,0.17,0.19,1";
            String BANK="0,0.04,0.08,1";
            String SOV="0,0.17,0.71";
            String PF="0,0.05,0.23,0.29,0.43";
            String INS="0,0.07,0.57";
            String CORP="0,0.09,0.17";
            String HF="0,0.14,0.29";
            String PB="0,0.07,0.11,0.37";
            String OTHER="";
        }
    }
}
