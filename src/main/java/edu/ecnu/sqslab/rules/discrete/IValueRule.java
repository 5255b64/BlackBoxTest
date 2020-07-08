package edu.ecnu.sqslab.rules.discrete;

/**
 * 字段取值的规则接口
 * 根据以下类型进行分类：
 * 1.Enum 枚举
 * 2.Range 取值范围
 * 3.随机值(规则之外的值)
 */
public interface IValueRule {
    /**
     * 判断输入参数 value 是否满足该ValueRule
     * @param value
     * @return 满足条件则返回 True
     *          不满足则返回 False
     */
    public boolean isApply(String value) throws Exception;
    public String toString();
}
