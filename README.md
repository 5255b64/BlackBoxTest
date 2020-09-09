## TODO LIST

- [x] 1 日志提取parser
- [x] 2 变异生成 测试用例 日志 （1000条）
- [ ] 3 人工测试用例 日志
- [ ] 4 结构化生成 测试用例 日志
- [x] 5 testcase code 分解
- [x] 6 testcase 字段 离散化
- [x] 7 testcase 字段 组合 特征提取
- [ ] 8 testcase 字段组合特征 聚类削减
- [ ] 9 削减后验证 使用覆盖率指标（是否改用新指标“每个probe出现的次数”？）
---

## 项目结构
- rules 保存测试接口的规则，包括字段、每个字段的取值范围。
  注：对于不同的接口，需要构建不同的rules类。
- testsuite 保存测试用例的值，包括测试用例的具体代码（Code）以及测试用例的桩数据（用于计算覆盖率）。
  注：TestSuiteManager类包含Testcase列，Testcase类包含ProbeInfo类。
- rules.discrete 对测试规则进行离散化，每个字段的取值范围，以有限数量形式表示。对于枚举值，不作额外处理；对于数值类型，根据取值范围/实际样本分布/用户给定的粒度参数，作一定的划分；对于字符串类型，统计判断其是否为枚举类型，若不为枚举，那么只根据有值与空值进行区分。
- feature 用于提取特征的工具。给定一个testcase，先分析测试用例（Code）中的字段取值，然后获取rules.discrete中的离散映射。统计所有离散映射，获取组合特征（combination feature）。
  注：IFeatureParser用于（仅）对一条testcase，提取n-way组合特征；实现IFeatureParser的类（CstpFeatureparser）使用到了Combination列。
- cli 命令行接口

---

