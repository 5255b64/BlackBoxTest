package edu.ecnu.sqslab.feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static edu.ecnu.sqslab.Config.DEFAULT_FEATURE_VALUE_INVALID;
import static edu.ecnu.sqslab.Config.DEFAULT_FIELD_NAME;

/**
 * 组合对象
 * combList保存组合的序号 以及每个序号特征的值 序号不能重复
 * 每次向combList插入之后 都要进行排序
 */
public class Combination {
    List<CombinationObject> combList;
    int combCount;      // 该Combination的次数统计

    public Combination() {
        combList = new ArrayList<>();
        combCount = 0;
    }

    /**
     * 拷贝构造函数
     *
     * @param comb
     */
    public Combination(Combination comb) {
        combList = new ArrayList<>();
        for (CombinationObject obj : comb.getCombList()) {
            combList.add(new CombinationObject(
                    obj.getFieldNum(),
                    obj.getFieldValue(),
                    obj.getFieldName())
            );
        }
    }

    public boolean add(int num) {
        CombinationObject obj = new CombinationObject(num, DEFAULT_FEATURE_VALUE_INVALID);
        if (combList.contains(obj)) {
            return false;
        } else {
            combList.add(obj);
            Collections.sort(combList);
            return true;
        }
    }

    public boolean add(int num, int value) {
        CombinationObject obj = new CombinationObject(num, value);
        if (combList.contains(obj)) {
            return false;
        } else {
            combList.add(obj);
            Collections.sort(combList);
            return true;
        }
    }

    /**
     * 检查该combination是否与目标combination相同
     * 若相同 则combCount++
     */
    public boolean equals(Combination comb) {
        boolean result = combList.equals(comb.getCombList());
//        if(result){
//            combCount++;
//        }
        return result;
    }

//    /**
//     * 检查combList中是否包含目标对象（字段相同、字段值相同）
//     *
//     * @param featureNum
//     * @param featureValue
//     * @return
//     */
//    public boolean containsNumValue(int featureNum, int featureValue) {
//        return combList.contains(new CombinationObject(featureNum, featureValue));
//    }

    /**
     * 检查combList中是否包含目标字段
     * @param featureNum
     * @return
     */
    public boolean containsNum(int featureNum) {
        boolean result = false;
        for(int i=0;i<combList.size();i++){
            if(combList.get(i).getFieldNum().equals(featureNum)){
                result = true;
                break;
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (CombinationObject obj : combList) {
            result.append(obj.getFieldNum()).append("-");
        }
        int index = result.lastIndexOf("-");
        if (index > 0) {
            result.delete(index, index + 1);
        }

        result.append(":");

        for (CombinationObject obj : combList) {
            result.append("\"").append(obj.getFieldValue()).append("\"-");
        }
        index = result.lastIndexOf("-");
        if (index > 0) {
            result.delete(index, index + 1);
        }
        return result.toString();
    }

    public List<CombinationObject> getCombList() {
        return combList;
    }

    public void setCombCount(int combCount) {
        this.combCount = combCount;
    }

    public int getCombCount() {
        return combCount;
    }
    class CombinationObject implements Comparable {
        Integer fieldNum;     // 字段在rule中的编号
        Integer fieldValue;   // 字段在取值在rule中的编号
        String fieldName;     // 字段名(不必要)

        public CombinationObject() {
            fieldNum = -1;
            fieldValue = -1;
            fieldName = DEFAULT_FIELD_NAME;
        }

        public CombinationObject(int featureNum, int featureValue) {
            this();
            this.fieldNum = featureNum;
            this.fieldValue = featureValue;
        }

        public CombinationObject(int featureNum, int featureValue, String featureName) {
            this.fieldNum = featureNum;
            this.fieldValue = featureValue;
            this.fieldName = featureName;
        }

        @Override
        public int compareTo(Object o) {
            return fieldNum.compareTo(((CombinationObject) o).getFieldNum());
        }

        public Integer getFieldNum() {
            return fieldNum;
        }

        public Integer getFieldValue() {
            return fieldValue;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldValue(int fieldValue) {
            this.fieldValue = fieldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof CombinationObject)) {
                return false;
            }
            return fieldNum.equals(((CombinationObject) o).getFieldNum()) &&
                    fieldValue.equals(((CombinationObject) o).getFieldValue());
        }
    }
}

