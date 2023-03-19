package com.shardingjdbc.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
@Slf4j
public class MyDbPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long>{

    /**
     * 分片策略
     * @param availableTargetNames 所有的数据源
     * @param preciseShardingValue SQL执行时传入的分片值
     * @return 返回
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> preciseShardingValue) {
        //真实节点
        availableTargetNames.forEach(a -> log.info("actual node db:{}", a));

        log.info("logic table name:{}, route column:{}" , preciseShardingValue.getLogicTableName(), preciseShardingValue.getColumnName());

        //精确分片
        log.info("column name:{}", preciseShardingValue.getValue());

        for (String availableTargetName : availableTargetNames) {
            Long value = preciseShardingValue.getValue();
            if (("ds"+value%2).equals(availableTargetName)) {
                return availableTargetName;
            }
        }
        return null;
    }
}
