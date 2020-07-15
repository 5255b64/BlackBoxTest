package edu.ecnu.sqslab.feature;

import edu.ecnu.sqslab.util.MyPair;

import java.util.ArrayList;
import java.util.List;

/**
 * n-way 特征对象
 * 使用数组保存n-way特征
 */
public class NWayFeatureObject {
    List<MyPair<Integer,String>> featureList;   // 保存特征的数组 数组成都为n

    public NWayFeatureObject(){
        featureList = new ArrayList<>();
    }
}
